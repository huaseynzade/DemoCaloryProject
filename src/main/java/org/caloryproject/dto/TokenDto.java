package org.caloryproject.dto;

import lombok.Builder;
import lombok.Data;
import org.caloryproject.enums.RoleEnum;

@Data
@Builder
public class TokenDto {
    private String username;
    private String token;
    private RoleEnum role;
}
