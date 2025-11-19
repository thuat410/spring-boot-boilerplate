package com.demo.common.service.mysql.impl;

import com.demo.common.dto.UserDTO;
import com.demo.common.entity.mysql.UserEntity;
import com.demo.common.enums.UserStatusEnum;
import com.demo.common.mapper.UserMapper;
import com.demo.common.repository.mysql.UserRepository;
import com.demo.common.service.mysql.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public UserDTO findById(Long id) {
        UserEntity entity = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return mapper.entityToDto(entity);
    }

    @Override
    public UserDTO updateUserStatus(Long id, UserStatusEnum status) {
        UserEntity entity = repository.findById(id).orElseThrow(NoSuchElementException::new);
        entity.setStatus(status);
        repository.save(entity);
        return mapper.entityToDto(entity);
    }


}
