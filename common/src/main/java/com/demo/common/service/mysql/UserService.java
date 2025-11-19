package com.demo.common.service.mysql;

import com.demo.common.dto.UserDTO;
import com.demo.common.enums.UserStatusEnum;

public interface UserService {
    UserDTO findById(Long id);
    UserDTO updateUserStatus(Long id, UserStatusEnum status);
}
