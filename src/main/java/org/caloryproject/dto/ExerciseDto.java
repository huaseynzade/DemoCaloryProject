package org.caloryproject.dto;


import lombok.Data;

@Data
public class ExerciseDto {

    private Integer id;

    private  String name;
    private String equipment;
    private String instructions;

    private Double duration;
    private Double burnCalories;

    private Integer categoryId;

}
