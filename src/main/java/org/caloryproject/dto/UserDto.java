package org.caloryproject.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.caloryproject.enums.GenderEnum;
import org.caloryproject.enums.RoleEnum;

@Data
public class UserDto {
    private Integer id;

    private String username;
    private String email;
    private String password;

    private GenderEnum gender;

    private RoleEnum role;


    private double weight;
    private double height;

}
