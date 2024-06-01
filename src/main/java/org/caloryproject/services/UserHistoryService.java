package org.caloryproject.services;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.caloryproject.dto.HistoryDto;
import org.caloryproject.entity.UserEntity;
import org.caloryproject.entity.UserHistoryEntity;
import org.caloryproject.map.HistoryMap;
import org.caloryproject.repository.HistoryRepository;
import org.caloryproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserHistoryService {
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final HistoryRepository repository;
    private final HistoryMap map;


    public List<HistoryDto> findUserHistory(HttpServletRequest request){
        Integer userId = jwtService.getUserId(jwtService.resolveClaims(request));
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("You haven't exercised yet"));
        return repository.findAllByUser(user).stream().map(map::toDto).toList();
    }


}
