package com.demo.mysql.mapper;

import com.demo.mysql.dto.UserDTO;
import com.demo.mysql.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO entityToDto(UserEntity entity);
    UserEntity dtoToEntity(UserDTO dto);
    void updateEntity(@MappingTarget UserEntity entity, UserDTO dto);
}
