package com.food.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.food.menu.dto.FoodItemDTO;
import com.food.menu.dto.FoodMenuDTO;
import com.food.menu.dto.RestaurantDTO;
import com.food.menu.entity.FoodItem;
import com.food.menu.mapper.FoodItemMapper;
import com.food.menu.repo.FoodItemRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FoodMenuService {

	@Autowired
	private FoodItemRepository foodItemRepository;

	@Autowired
	private RestTemplate restTemplate;

	public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
		log.info("FoodMenuService - addFoodItem() called for food item: {}", foodItemDTO.getFoodItemName());
		FoodItem foodItem = foodItemRepository.save(FoodItemMapper.INSTANCE.mapToFoodItemDTOToFoodItem(foodItemDTO));
		log.info("FoodMenuService - Food item saved with ID: {}", foodItem.getId());
		return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(foodItem);
	}

	public FoodMenuDTO fetchFoodCataloguePageDetails(Integer restaurantId) {
		log.info("FoodMenuService - fetchFoodCataloguePageDetails() called with restaurantId: {}", restaurantId);
		List<FoodItem> foodItemList = fetchFoodItemList(restaurantId);
		log.info("FoodMenuService - Found {} food items for restaurantId: {}",
				foodItemList == null ? 0 : foodItemList.size(), restaurantId);
		RestaurantDTO restaurant = fetchRestaurantDetailsFromRestaurantMS(restaurantId);
		if (restaurant == null) {
			log.warn("FoodMenuService - No restaurant details found for restaurantId: {}", restaurantId);
		} else {
			log.info("FoodMenuService - Retrieved restaurant details for restaurantId: {}", restaurantId);
		}
		return createFoodMenuDTO(foodItemList, restaurant);
	}

	private FoodMenuDTO createFoodMenuDTO(List<FoodItem> foodItemList, RestaurantDTO restaurant) {
		log.debug("FoodMenuService - Creating FoodMenuDTO");
		FoodMenuDTO foodCataloguePage = new FoodMenuDTO();
		foodCataloguePage.setFoodItemsList(foodItemList);
		foodCataloguePage.setRestaurantDTO(restaurant);
		return foodCataloguePage;
	}

	private RestaurantDTO fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
		try {
			log.debug("FoodMenuService - Calling Restaurant MS for restaurantId: {}", restaurantId);
			return restTemplate.getForObject("http://RESTAURANT-LISTING-SERVICE/restaurant/fetchById/" + restaurantId,
					RestaurantDTO.class);
		} catch (Exception ex) {
			log.error("FoodMenuService - Error fetching restaurant details for restaurantId: {} - {}", restaurantId,
					ex.getMessage(), ex);
			return null;
		}
	}

	private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
		log.debug("FoodMenuService - Fetching food items for restaurantId: {}", restaurantId);
		List<FoodItem> foodItems = foodItemRepository.findByRestaurantId(restaurantId);
		if (foodItems == null || foodItems.isEmpty()) {
			log.warn("FoodMenuService - No food items found for restaurantId: {}", restaurantId);
		}
		return foodItems;
	}

}
