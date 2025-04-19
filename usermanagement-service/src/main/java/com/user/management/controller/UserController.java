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

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/addUser")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
		UserDTO user = userService.addUser(userDTO);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@GetMapping("/fetchUserById/{userId}")
	public ResponseEntity<UserDTO> fetchUserDetailsById(@PathVariable Integer userId) {
		return userService.fetchUserDetailsById(userId);
	}
}
