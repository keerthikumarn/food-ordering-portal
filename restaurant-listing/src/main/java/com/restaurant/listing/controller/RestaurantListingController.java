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

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
@Slf4j
public class RestaurantListingController {

	@Autowired
	private RestaurantService restaurantService;

	@GetMapping("/getAllRestaurants")
	public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurants() {
		log.info("RestaurantController - fetchAllRestaurants() invoked");
		List<RestaurantDTO> restaurantsList = restaurantService.findAllRestaurants();
		log.info("RestaurantController - fetchAllRestaurants() returned {} restaurants", restaurantsList.size());
		return new ResponseEntity<>(restaurantsList, HttpStatus.OK);
	}

	@PostMapping("/addRestaurant")
	public ResponseEntity<RestaurantDTO> saveRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
		log.info("RestaurantController - saveRestaurant() invoked");
		RestaurantDTO savedRestaurant = restaurantService.saveRestaurant(restaurantDTO);
		log.info("RestaurantController - saveRestaurant() successfully saved restaurant with ID: {}",
				savedRestaurant.getId());
		return new ResponseEntity<>(savedRestaurant, HttpStatus.CREATED);
	}

	@GetMapping("/fetchById/{id}")
	public ResponseEntity<RestaurantDTO> findRestaurantById(@PathVariable Integer id) {
		log.info("RestaurantController - findRestaurantById() called with ID: {}", id);
		RestaurantDTO restaurantDTO = restaurantService.fetchRestaurantById(id);
		if (restaurantDTO != null) {
		    log.info("RestaurantController - Restaurant found with ID: {}", id);
		} else {
		    log.warn("RestaurantController - No restaurant found for ID: {}", id);
		}
		return new ResponseEntity<>(restaurantDTO, HttpStatus.OK);
	}
}
