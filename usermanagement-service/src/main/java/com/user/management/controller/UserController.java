package com.user.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.management.dto.UserDTO;
import com.user.management.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/addUser")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
		log.info("UserController - addUser() called with username: {}", userDTO.getUsername());
		UserDTO user = userService.addUser(userDTO);
		log.info("UserController - User created/added with ID: {}", user.getId());
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@GetMapping("/fetchUserById/{userId}")
	public ResponseEntity<UserDTO> fetchUserDetailsById(@PathVariable Integer userId) {
		log.info("UserController - fetchUserDetailsById() called with userId: {}", userId);
		ResponseEntity<UserDTO> response = userService.fetchUserDetailsById(userId);
        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("UserController - User details retrieved for userId: {}", userId);
        } else if (response.getStatusCode().is4xxClientError()) {
            log.warn("UserController - User not found for userId: {}", userId);
        }
        return response;
	}
}
