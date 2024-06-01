package org.caloryproject.dto;

import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.caloryproject.entity.ExercisesEntity;
import org.caloryproject.entity.UserEntity;

import java.time.LocalDateTime;

@Data
public class HistoryDto {
    private Integer id;

    private Integer userId;

    private LocalDateTime time = LocalDateTime.now();

    private Integer exerciseId;
    private Double duration;
    private Double burnedCalories;

}
