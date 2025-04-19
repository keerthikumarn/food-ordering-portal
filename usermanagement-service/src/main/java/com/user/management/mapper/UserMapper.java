package com.user.management.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.user.management.dto.UserDTO;
import com.user.management.entity.User;

@Mapper
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	User mapUserDTOToUser(UserDTO userDto);

	UserDTO mapUserToUserDTO(User user);
}
