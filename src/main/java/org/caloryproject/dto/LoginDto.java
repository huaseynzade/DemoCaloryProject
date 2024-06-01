package org.caloryproject.dto;

import lombok.Data;
import org.caloryproject.enums.GenderEnum;

@Data
public class LoginDto {
    private String username;
    private String password;
}
