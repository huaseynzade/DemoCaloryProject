package org.caloryproject.map;

import org.caloryproject.dto.HistoryDto;
import org.caloryproject.entity.UserHistoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HistoryMap {

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "exerciseId", target = "exercise.id")
    UserHistoryEntity toEntity(HistoryDto historyDto);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "exercise.id", target = "exerciseId")
    HistoryDto toDto(UserHistoryEntity entity);

}
