package com.food.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.food.menu.dto.FoodItemDTO;
import com.food.menu.dto.FoodMenuDTO;
import com.food.menu.dto.RestaurantDTO;
import com.food.menu.entity.FoodItem;
import com.food.menu.mapper.FoodItemMapper;
import com.food.menu.repo.FoodItemRepository;

public class FoodMenuService {

	@Autowired
	private FoodItemRepository foodItemRepository;

	@Autowired
	private RestTemplate restTemplate;

	public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
		FoodItem foodItem = foodItemRepository.save(FoodItemMapper.INSTANCE.mapToFoodItemDTOToFoodItem(foodItemDTO));
		return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(foodItem);
	}

	public FoodMenuDTO fetchFoodCataloguePageDetails(Integer restaurantId) {
		List<FoodItem> foodItemList = fetchFoodItemList(restaurantId);
		RestaurantDTO restaurant = fetchRestaurantDetailsFromRestaurantMS(restaurantId);
		return createFoodMenuDTO(foodItemList, restaurant);
	}

	private FoodMenuDTO createFoodMenuDTO(List<FoodItem> foodItemList, RestaurantDTO restaurant) {
		FoodMenuDTO foodCataloguePage = new FoodMenuDTO();
		foodCataloguePage.setFoodItemsList(foodItemList);
		foodCataloguePage.setRestaurantDTO(restaurant);
		return foodCataloguePage;
	}

	private RestaurantDTO fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
		return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchById/" + restaurantId,
				RestaurantDTO.class);
	}

	private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
		return foodItemRepository.findByRestaurantId(restaurantId);
	}

}
