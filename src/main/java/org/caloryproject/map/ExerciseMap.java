package org.caloryproject.map;


import org.caloryproject.dto.ExerciseDto;
import org.caloryproject.entity.ExercisesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExerciseMap{


    @Mapping(source = "categoryId", target = "category.id")
    ExercisesEntity toEntity(ExerciseDto dto);

    @Mapping(source = "category.id", target = "categoryId")
    ExerciseDto toDto(ExercisesEntity entity);

}
