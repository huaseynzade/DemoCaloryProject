package org.caloryproject.configuration;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.caloryproject.services.JwtService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.util.Enumeration;
import java.io.IOException;
import java.util.Collection;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final JwtService jwtUtil;


    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {

        try {

            String accessToken = jwtUtil.resolveToken(request);
            log.debug("Access token resolved: {}", accessToken);

            if (accessToken == null) {
                filterChain.doFilter(request, response);
//                log.info("Token is null");
                return;
            }

            Claims claims = jwtUtil.resolveClaims(request);
            log.debug("Claims resolved: {}", claims);

            if (claims != null && jwtUtil.validateClaims(claims)) {
                String user = claims.getSubject();
                Collection<GrantedAuthority> authorities = jwtUtil.extractAuthorities(claims);
                Authentication authentication = new UsernamePasswordAuthenticationToken(user, "", authorities);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                log.debug("Authentication set for user: {}", user);
            } else {
                log.debug("Invalid claims or failed to validate claims.");
            }
        } catch (Exception e) {
            log.error("Error due to: {}", e.getClass().getName() + " -> " + e.getMessage(), e);
        }
        filterChain.doFilter(request, response);
    }
}
