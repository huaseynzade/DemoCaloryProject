package org.caloryproject.services;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.caloryproject.entity.UserEntity;
import org.caloryproject.enums.RoleEnum;
import org.caloryproject.repository.UserRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import java.security.Key;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class JwtService {
    private final UserRepository repository;


    private final String secret_key = "QmFzZTY0IGVuY29kaW5nIHNjaGVtZXMgYXJlIGNvbW1vbmx5IHVzZWQgd2hlbiB0aGVyZSBpcyBhIG5lZWQgdG8gZW5jb2RlIGJpbmFyeSBkYXRhLCBlc3BlY2lhbGx5IHdoZW4gdGhhdCBkYXRhIG5lZWRzIHRvIGJlIHN0b3JlZCBhbmQgdHJhbnNmZXJyZWQgb3ZlciBtZWRpYSB0aGF0IGFyZSBkZXNpZ25lZCB0byBkZWFsIHdpdGggdGV4dC4gVGhpcyBlbmNvZGluZyBoZWxwcyB0byBlbnN1cmUgdGhhdCB0aGUgZGF0YSByZW1haW5zIGludGFjdCB3aXRob3V0IG1vZGlmaWNhdGlvbiBkdXJpbmcgdHJhbnNwb3J0LiBCYXNlNjQgaXMgdXNlZCBjb21tb25seSBpbiBhIG51bWJlciBvZiBhcHBsaWNhdGlvbnMgaW5jbHVkaW5nIGVtYWlsIHZpYSBNSU1FLCBhcyB3ZWxsIGFzIHN0b3JpbmcgY29tcGxleCBkYXRh";

    private final long accessTokenValidity = 86400000;
    private static Key key;


    public Key initializeKey(){
        byte[] keyBytes;
        keyBytes = Decoders.BASE64.decode(secret_key);
        key = Keys.hmacShaKeyFor(keyBytes);
        return key;
    }
    public String createToken(UserEntity client, HttpServletResponse response){
        log.info("ActionLog.JwtService.createToken method is started");

        key = initializeKey();
        client =  repository.findByUsername(client.getUsername()).orElseThrow(() -> new EntityNotFoundException("CLIENT_NOT_FOUND"));
        Claims claims = Jwts.claims().setSubject(client.getUsername());
        Set<RoleEnum> authorities = Set.of(client.getRole());
        List<String> roles = new ArrayList<>();
        for (RoleEnum authority : authorities) {
            roles.add(authority.name());
        }
        Map<String, Object> claimsMap = new HashMap<>();
        claimsMap.put("authorities",roles);
        claimsMap.put("username", client.getUsername());
        claimsMap.put("user_id", client.getId());

        Date tokenCreateTime = new Date();
        Date tokenValidity = new Date(tokenCreateTime.getTime() + TimeUnit.MINUTES.toMillis(accessTokenValidity));
        final JwtBuilder jwtBuilder = Jwts.builder()
                .setSubject(client.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(tokenValidity)
                .addClaims(claimsMap)
                .signWith(key, SignatureAlgorithm.HS512);

//        response.setHeader("Authorization", "Bearer " + jwtBuilder);
        return jwtBuilder.compact();
    }

    private Claims parseJwtClaims(String token) {
        return Jwts.parser().setSigningKey(secret_key).parseClaimsJws(token).getBody();
    }

    public Claims resolveClaims(HttpServletRequest req) {
        try {
            String token = resolveToken(req);
            if (token != null) {
                return parseJwtClaims(token);
            }
            log.info("token is null");
            return null;
        } catch (ExpiredJwtException ex) {
            log.error("Error due to: {}", ex.getMessage());
            req.setAttribute("expired", ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            log.error("Error due to: {}", ex.getMessage());
            req.setAttribute("invalid", ex.getMessage());
            throw ex;
        }
    }

    public String resolveToken(HttpServletRequest request) {

        String TOKEN_HEADER = "Authorization";
        String bearerToken = request.getHeader(TOKEN_HEADER);
//        log.info(bearerToken);
        String TOKEN_PREFIX = "Bearer ";
        if (bearerToken != null && bearerToken.startsWith(TOKEN_PREFIX)) {
//            log.info("JWTSERVICE : 96 WORKS");
            return bearerToken.substring(TOKEN_PREFIX.length());
        }
//        log.info("JWTSERVICE : 99 WORKS");
        return null;
    }

    public boolean validateClaims(Claims claims){
        return claims.getExpiration().after(new Date());
    }



    public Integer getUserId(Claims claims){
        return (Integer) claims.get("user_id");
    }



    public Collection<GrantedAuthority> extractAuthorities(Claims claims) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if (claims.containsKey("authorities")) {
            List<String> roles = (List<String>) claims.get("authorities");
            for (String role : roles) {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
            }
        }
        return authorities;
    }

}