package org.caloryproject.map;

import org.caloryproject.dto.CategoryDto;
import org.caloryproject.entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMap {

    CategoryEntity toEntity(CategoryDto dto);

    CategoryDto toDto(CategoryEntity entity);



}
