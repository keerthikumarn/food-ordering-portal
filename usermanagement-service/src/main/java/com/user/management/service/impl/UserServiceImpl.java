package com.user.management.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.user.management.dto.UserDTO;
import com.user.management.entity.User;
import com.user.management.mapper.UserMapper;
import com.user.management.repo.UserRepository;
import com.user.management.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDTO addUser(UserDTO userDTO) {
		log.info("UserService - addUser() called for username: {}", userDTO.getUsername());
		User user = userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
		log.info("UserService - User saved successfully with ID: {}", user.getId());
		return UserMapper.INSTANCE.mapUserToUserDTO(user);
	}

	@Override
	public ResponseEntity<UserDTO> fetchUserDetailsById(Integer userId) {
		log.info("UserService - fetchUserDetailsById() called with userId: {}", userId);
		Optional<User> user = userRepo.findById(userId);
		if (user.isPresent()) {
			log.info("UserService - User found for ID: {}", userId);
			return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(user.get()), HttpStatus.OK);
		} else {
			log.warn("UserService - No user found for ID: {}", userId);
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

}
