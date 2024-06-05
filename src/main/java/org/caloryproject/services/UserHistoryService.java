package org.caloryproject.services;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RequiredArgsConstructor
public class UserHistoryService {
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final HistoryRepository repository;
    private final HistoryMap map;


    public List<HistoryDto> findUserHistory(HttpServletRequest request){
        Integer userId = jwtService.getUserId(jwtService.resolveClaims(request));
        log.info("UserHistoryService.findUserHistory is working for by id {}", userId);
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("You haven't exercised yet"));
        List<HistoryDto> list = repository.findAllByUser(user).stream().map(map::toDto).toList();
        log.info("UserHistoryService.findUserHistory is finished by id {}, weekly history contains {}", userId,list.size());
        return list;
    }


}
