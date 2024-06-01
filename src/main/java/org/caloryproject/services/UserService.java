package org.caloryproject.services;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.caloryproject.dto.UserResponseDto;
import org.caloryproject.entity.UserEntity;
import org.caloryproject.exceptions.NotFoundException;
import org.caloryproject.map.UserMap;
import org.caloryproject.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RequiredArgsConstructor
public class UserService {
    private final JwtService jwtService;
    private final UserRepository repository;
    private final UserMap map;


    public UserResponseDto profile(HttpServletRequest request){
        Integer userId = jwtService.getUserId(jwtService.resolveClaims(request));
        UserEntity userEntity = repository.findById(userId).orElseThrow(() -> new NotFoundException("User Not Found"));
        return map.toDto(userEntity);
    }


}
