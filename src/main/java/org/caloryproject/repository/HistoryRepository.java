package org.caloryproject.repository;

import org.caloryproject.entity.UserEntity;
import org.caloryproject.entity.UserHistoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HistoryRepository extends CrudRepository<UserHistoryEntity,Integer> {
    List<UserHistoryEntity> findAllByUser(UserEntity user);


    @Query("SELECT SUM(u.burnedCalories) FROM UserHistoryEntity u WHERE u.user = :user and u.time > :lastTime")
    Double findTotalBurnCaloriesByUserIdAndCheckTime(UserEntity user, LocalDateTime lastTime);
    @Query("SELECT SUM(u.burnedCalories) FROM UserHistoryEntity u WHERE u.user = :user and u.time > :date")
    Double findWeeklyBurnCaloriesByUserId(UserEntity user, LocalDateTime date);



}
