package com.restaurant.listing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.listing.dto.RestaurantDTO;
import com.restaurant.listing.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantListingController {

	@Autowired
	private RestaurantService restaurantService;

	@GetMapping("/getAllRestaurants")
	public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurants() {
		List<RestaurantDTO> restaurantsList = restaurantService.findAllRestaurants();
		return new ResponseEntity<>(restaurantsList, HttpStatus.OK);
	}

	@PostMapping("/addRestaurant")
	public ResponseEntity<RestaurantDTO> saveRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
		RestaurantDTO restaurant = restaurantService.saveRestaurant(restaurantDTO);
		return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
	}

	@GetMapping("/fetchById/{id}")
	public ResponseEntity<RestaurantDTO> findRestaurantById(@PathVariable Integer id) {
		RestaurantDTO restaurantDTO = restaurantService.fetchRestaurantById(id);
		return new ResponseEntity<>(restaurantDTO, HttpStatus.OK);
	}
}
