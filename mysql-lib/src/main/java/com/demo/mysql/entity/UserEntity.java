package com.demo.mysql.entity;

import com.demo.mysql.enums.UserRoleEnum;
import com.demo.mysql.enums.UserStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "user")
@Getter
@Setter
public class UserEntity extends BaseEntity {
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserStatusEnum status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRoleEnum role;
}
