package org.caloryproject.services;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.caloryproject.entity.ExercisesEntity;
import org.caloryproject.entity.UserEntity;
import org.caloryproject.entity.UserHistoryEntity;
import org.caloryproject.exceptions.ActivateException;
import org.caloryproject.exceptions.NotFoundException;
import org.caloryproject.map.HistoryMap;
import org.caloryproject.repository.ExerciseRepository;
import org.caloryproject.repository.HistoryRepository;
import org.caloryproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class PracticeService {
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final HistoryRepository historyRepository;

    private final HistoryMap historyMap;
    private final ExerciseRepository exerciseRepository;

    public void training(HttpServletRequest request, Integer exerciseId, Double duration){
        Integer userId = jwtService.getUserId(jwtService.resolveClaims(request));

        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User Not Found"));
        if (!user.getIsActivated()){
            throw new ActivateException("Activate Your Account First");
        }
        ExercisesEntity exercise = exerciseRepository.findById(exerciseId).orElseThrow(() -> new NotFoundException("Exercise Not Found"));
        Double burnedCalories = exercise.getBurnCalories() * (duration/exercise.getDuration());

        UserHistoryEntity history = UserHistoryEntity.builder()
                .burnedCalories(burnedCalories)
                .user(user)
                .time(LocalDateTime.now())
                .exercise(exercise)
                .duration(duration)
                .build();

        historyRepository.save(history);

    }
    public Double currentWeight(Integer calorieInTake, HttpServletRequest request){
        Integer userId = jwtService.getUserId(jwtService.resolveClaims(request));
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User Not Found"));
        if (!user.getIsActivated()){
            throw new ActivateException("Activate Your Account First");
        }
        LocalDateTime lastCheckTime = user.getLastCheckTime();
        Double totalBurnedCalories = historyRepository.findTotalBurnCaloriesByUserIdAndCheckTime(user, lastCheckTime);

        double resultKg = 0;
        if (historyRepository.findTotalBurnCaloriesByUserIdAndCheckTime(user,user.getLastCheckTime()) == null) {
            resultKg = ((user.getWeight() * 7700)  + calorieInTake) / 7700;
        }else{
            resultKg = (((user.getWeight() * 7700) - historyRepository.findTotalBurnCaloriesByUserIdAndCheckTime(user, user.getLastCheckTime())) + calorieInTake) / 7700;
        }
        user.setLastCheckTime(LocalDateTime.now());
        user.setWeight(resultKg);
        userRepository.save(user);
        return resultKg;
    }

    public Double getWeeklyBurnCalories(HttpServletRequest request){
        Integer userId = jwtService.getUserId(jwtService.resolveClaims(request));
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("You haven't exercised yet"));
        if (!user.getIsActivated()){
            throw new ActivateException("Activate Your Account First");
        }
        LocalDate date = LocalDate.now();
        LocalDate weekBefore = date.minusWeeks(1);
        return historyRepository.findWeeklyBurnCaloriesByUserId(user, weekBefore);
    }

}
