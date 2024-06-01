package org.caloryproject.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.caloryproject.enums.GenderEnum;
import org.caloryproject.enums.RoleEnum;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;


    private double weight;
    private double height;

    private Boolean isActivated = false;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;


    @OneToMany(mappedBy = "user")
    private List<UserHistoryEntity> historyEntityList;

    @JsonIgnore
    private LocalDateTime lastCheckTime = LocalDateTime.now();

}
