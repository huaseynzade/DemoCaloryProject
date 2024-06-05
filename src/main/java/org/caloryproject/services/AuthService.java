package org.caloryproject.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Response;
import org.caloryproject.configuration.MailSenderConfig;
import org.caloryproject.dto.LoginDto;
import org.caloryproject.dto.TokenDto;
import org.caloryproject.dto.UserDto;
import org.caloryproject.entity.UserActivateCode;
import org.caloryproject.entity.UserEntity;
import org.caloryproject.exceptions.InvalidActivationCode;
import org.caloryproject.exceptions.NotFoundException;
import org.caloryproject.map.UserMap;
import org.caloryproject.repository.UserActivationRepository;
import org.caloryproject.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserMap userMap;
    private final UserRepository repository;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder encoder;
    private final MailSenderConfig mailSender;
    private final UserActivationRepository activationRepo;




    public ResponseEntity<?> login(LoginDto loginDto, HttpServletResponse response){
        try {
            log.info("Login method started for username {}", loginDto.getUsername());
            if (repository.findByUsername(loginDto.getUsername()).isEmpty()){
                throw new RuntimeException("Wrong Username");
            }
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
            log.info("Authentication Info {}", authentication);



            UserEntity entity = repository.findByUsername(loginDto.getUsername()).orElseThrow();
            String token = jwtService.createToken(entity, response);

            TokenDto tokenDto = TokenDto.builder().username(loginDto.getUsername()).token(token).role(entity.getRole()).build();
            ResponseEntity<TokenDto> responseEntity = ResponseEntity.status(HttpStatus.OK).header("userId", String.valueOf(entity.getId())).body(tokenDto);
            log.info("Login successfully completed for user {}", entity.getUsername());
            return responseEntity;
        }catch (BadCredentialsException exception){
            throw new  RuntimeException("Invalid password");
        }

    }


    public void register(UserDto userDto){
        if (repository.findByUsername(userDto.getUsername()).isPresent()){
            throw new RuntimeException("Username already Exist");
        }
        log.info("Register method started for user {}", userDto.getUsername());
        UserEntity userEntity = userMap.toEntity(userDto);
        userEntity.setLastCheckTime(LocalDateTime.now());
        userEntity.setPassword(encoder.encode(userDto.getPassword()));
        repository.save(userEntity);
        log.info("Register method finished for user {}, id is {}", userDto.getUsername(), userDto.getId());
    }


    public void sendCode(HttpServletRequest request){
        Integer userId = jwtService.getUserId(jwtService.resolveClaims(request));
        log.info("AuthService.sendCode is started for {}", userId);
        UserEntity user = repository.findById(userId).orElseThrow(() -> new NotFoundException("Not Found"));
        String mail = user.getEmail();
        Integer code = generateActivateCode(userId);

        mailSender.sendMail(mail,"Activation Code", "Your Code is " + code);
        UserActivateCode entity = UserActivateCode.builder()
                .activationCode(code)
                .user(user)
                .build();
        activationRepo.save(entity);
    }

    public void writeCode(HttpServletRequest request, Integer code){
        Integer userId = jwtService.getUserId(jwtService.resolveClaims(request));
        log.info("AuthService.writeCode is started for {}", userId);
        UserEntity user = repository.findById(userId).orElseThrow(() -> new NotFoundException("Not Found"));
        UserActivateCode entity = activationRepo.findByUser(user).orElseThrow(() -> new NotFoundException("Ask for code first"));
        if (code.equals(entity.getActivationCode())){
            user.setIsActivated(true);
            activationRepo.delete(entity);
            log.info("AuthService.writeCode user id {} activated", userId);
        }else{
            throw new InvalidActivationCode("Invalid Activation code try again");
        }
        repository.save(user);
        log.info("AuthService.writeCode is finished");
    }


    public Integer generateActivateCode(Integer userId){
        Random random = new Random();
        Integer randomCode = 1000 + random.nextInt(9000);
        log.info("Random code generated for user {}, code {}", userId,randomCode);
        return randomCode;
    }


}
