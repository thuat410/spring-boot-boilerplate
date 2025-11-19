package com.demo.common.mapper;

import com.demo.common.dto.UserDTO;
import com.demo.common.entity.mysql.UserEntity;
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
