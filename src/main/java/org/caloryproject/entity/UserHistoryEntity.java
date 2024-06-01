package org.caloryproject.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_history")
@Data
@Builder
@AllArgsConstructor
public class UserHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    private LocalDateTime time;


    @ManyToOne
    private UserEntity user;

    @ManyToOne
    private ExercisesEntity exercise;

    private Double duration;
    private Double burnedCalories;



}
