package com.food.menu.controller;

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

import com.food.menu.dto.FoodItemDTO;
import com.food.menu.dto.FoodMenuDTO;
import com.food.menu.service.FoodMenuService;

import lombok.extern.slf4j.Slf4j;

/**
 * This class is used to handle all the requests related to food menu.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/foodmenu")
@Slf4j
public class FoodMenuController {

	@Autowired
	private FoodMenuService foodMenuService;

	@PostMapping("/addFoodItem")
	public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO) {
		log.info("FoodMenuController - addFoodItem() invoked");
		FoodItemDTO foodItemSaved = foodMenuService.addFoodItem(foodItemDTO);
		log.info("FoodMenuController - addFoodItem() successfully saved food item with ID: {}", foodItemSaved.getId());
		return new ResponseEntity<>(foodItemSaved, HttpStatus.CREATED);
	}

	@GetMapping("/fetchRestaurantAndFoodItemsById/{restaurantId}")
	public ResponseEntity<FoodMenuDTO> fetchRestauDetailsWithFoodMenu(@PathVariable Integer restaurantId) {
		log.info("RestaurantController - fetchRestauDetailsWithFoodMenu() called with restaurantId: {}", restaurantId);
		FoodMenuDTO foodCataloguePage = foodMenuService.fetchFoodCataloguePageDetails(restaurantId);
		if (foodCataloguePage == null) {
			log.warn("RestaurantController - No food menu found for restaurantId: {}", restaurantId);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		log.info("RestaurantController - Successfully retrieved food menu for restaurantId: {}", restaurantId);
		return new ResponseEntity<>(foodCataloguePage, HttpStatus.OK);
	}

}
