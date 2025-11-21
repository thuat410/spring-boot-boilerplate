package com.demo.mysql.dto;

import com.demo.mysql.enums.UserRoleEnum;
import com.demo.mysql.enums.UserStatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String email;
    private UserStatusEnum status;
    private UserRoleEnum role;
}
