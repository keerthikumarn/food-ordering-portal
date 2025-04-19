package com.user.management.service;

import org.springframework.http.ResponseEntity;

import com.user.management.dto.UserDTO;

public interface UserService {
	
	public UserDTO addUser(UserDTO userDTO);
	
	public ResponseEntity<UserDTO> fetchUserDetailsById(Integer userId);

}
