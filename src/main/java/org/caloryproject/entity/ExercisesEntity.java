package org.caloryproject.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "exercises")
@Data
public class ExercisesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private  String name;
    private String equipment;
    private String instructions;

    // minutes
    private Double duration;
    private Double burnCalories;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;



}
