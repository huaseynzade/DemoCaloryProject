package org.caloryproject.map;

import org.caloryproject.dto.LoginDto;
import org.caloryproject.dto.UserDto;
import org.caloryproject.dto.UserResponseDto;
import org.caloryproject.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMap {

    UserEntity toEntity(UserDto userDto);

    UserResponseDto toDto(UserEntity user);


}
