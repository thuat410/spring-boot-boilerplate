package com.demo.mysql.service.impl;

import com.demo.mysql.dto.UserDTO;
import com.demo.mysql.entity.UserEntity;
import com.demo.mysql.enums.UserStatusEnum;
import com.demo.mysql.id.Id;
import com.demo.mysql.mapper.UserMapper;
import com.demo.mysql.repository.UserRepository;
import com.demo.mysql.service.UserService;
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
