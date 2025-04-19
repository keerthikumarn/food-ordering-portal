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

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDTO addUser(UserDTO userDTO) {
		User user = userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
		return UserMapper.INSTANCE.mapUserToUserDTO(user);
	}

	@Override
	public ResponseEntity<UserDTO> fetchUserDetailsById(Integer userId) {
		Optional<User> user = userRepo.findById(userId);
		if (user.isPresent()) {
			return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(user.get()), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

}
