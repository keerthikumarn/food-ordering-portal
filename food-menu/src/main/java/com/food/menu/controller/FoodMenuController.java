package com.food.menu.controller;

import static com.food.menu.constants.ApplicationConstants.ADD_FOOD_ITEM_PATH;
import static com.food.menu.constants.ApplicationConstants.FOOD_MENU_BASE_PATH;
import static com.food.menu.constants.ApplicationConstants.RESTAURANT_MENU_BY_ID_PATH;

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

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Handles all HTTP requests related to the food menu.
 */
@RestController
@RequestMapping(FOOD_MENU_BASE_PATH)
@RequiredArgsConstructor
@Slf4j
public class FoodMenuController {

	private final FoodMenuService foodMenuService;

	@PostMapping(ADD_FOOD_ITEM_PATH)
	public ResponseEntity<FoodItemDTO> addFoodItem(@Valid @RequestBody FoodItemDTO foodItemDTO) {
		log.info("Request received to add food item for restaurantId={}", foodItemDTO.getRestaurantId());
		FoodItemDTO foodItemSaved = foodMenuService.addFoodItem(foodItemDTO);
		return new ResponseEntity<>(foodItemSaved, HttpStatus.CREATED);
	}

	@GetMapping(RESTAURANT_MENU_BY_ID_PATH)
	public ResponseEntity<FoodMenuDTO> fetchRestaurantDetailsWithFoodMenu(@PathVariable Integer restaurantId) {
		log.info("Request received to fetch menu for restaurantId={}", restaurantId);
		FoodMenuDTO foodCataloguePage = foodMenuService.fetchFoodCataloguePageDetails(restaurantId);
		return new ResponseEntity<>(foodCataloguePage, HttpStatus.OK);
	}

}

