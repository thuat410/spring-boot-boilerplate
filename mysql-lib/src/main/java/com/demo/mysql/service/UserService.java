package com.demo.mysql.service;

import com.demo.mysql.dto.UserDTO;
import com.demo.mysql.enums.UserStatusEnum;

public interface UserService {
    UserDTO findById(Long id);
    UserDTO updateUserStatus(Long id, UserStatusEnum status);
}
