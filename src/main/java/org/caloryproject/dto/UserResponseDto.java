package org.caloryproject.dto;

import lombok.Data;
import org.caloryproject.enums.GenderEnum;
import org.caloryproject.enums.RoleEnum;

@Data
public class UserResponseDto {
    private Integer id;

    private String username;
    private String email;

    private GenderEnum gender;

    private RoleEnum role;

    private boolean isActivated;

    private double weight;
    private double height;
}
