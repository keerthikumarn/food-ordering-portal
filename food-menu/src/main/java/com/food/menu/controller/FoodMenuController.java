package com.food.menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.menu.dto.FoodItemDTO;
import com.food.menu.dto.FoodMenuDTO;
import com.food.menu.service.FoodMenuService;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * This class is used to handle all the requests related to food menu.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/foodmenu")
public class FoodMenuController {

	@Autowired
	private FoodMenuService foodMenuService;

	@PostMapping("/addFoodItem")
	public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO) {
		FoodItemDTO foodItemSaved = foodMenuService.addFoodItem(foodItemDTO);
		return new ResponseEntity<>(foodItemSaved, HttpStatus.CREATED);
	}

	@GetMapping("/fetchRestaurantAndFoodItemsById/{restaurantId}")
	public ResponseEntity<FoodMenuDTO> fetchRestauDetailsWithFoodMenu(@PathVariable Integer restaurantId) {
		FoodMenuDTO foodCataloguePage = foodMenuService.fetchFoodCataloguePageDetails(restaurantId);
		return new ResponseEntity<>(foodCataloguePage, HttpStatus.OK);

	}

}
