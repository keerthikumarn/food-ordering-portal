package com.food.menu.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;

import com.food.menu.dto.FoodItemDTO;
import com.food.menu.dto.FoodMenuDTO;
import com.food.menu.dto.RestaurantDTO;
import com.food.menu.entity.FoodItem;
import com.food.menu.mapper.FoodItemMapper;
import com.food.menu.repo.FoodItemRepository;

import com.food.menu.exception.RestaurantServiceException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.food.menu.constants.ApplicationConstants.ERROR_FOOD_ITEMS_NOT_FOUND;
import static com.food.menu.constants.ApplicationConstants.ERROR_RESTAURANT_SERVICE_UNAVAILABLE;
import static com.food.menu.constants.ApplicationConstants.RESTAURANT_SERVICE_FETCH_BY_ID_URL;

@Service
@RequiredArgsConstructor
@Slf4j
public class FoodMenuService {

	private final FoodItemRepository foodItemRepository;
	private final RestTemplate restTemplate;
	private final FoodItemMapper foodItemMapper;

	public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
		log.debug("Persisting food item for restaurantId={}", foodItemDTO.getRestaurantId());
		FoodItem foodItem = foodItemRepository.save(foodItemMapper.mapToFoodItemDTOToFoodItem(foodItemDTO));
		return foodItemMapper.mapFoodItemToFoodItemDTO(foodItem);
	}

	public FoodMenuDTO fetchFoodCataloguePageDetails(Integer restaurantId) {
		log.debug("Fetching food catalogue for restaurantId={}", restaurantId);

		List<FoodItem> foodItemList = fetchFoodItemList(restaurantId);
		if (foodItemList == null || foodItemList.isEmpty()) {
			log.warn("No food items configured for restaurantId={}", restaurantId);
			throw new IllegalStateException(ERROR_FOOD_ITEMS_NOT_FOUND);
		}

		RestaurantDTO restaurant = fetchRestaurantDetailsFromRestaurantMS(restaurantId);
		return createFoodMenuDTO(foodItemList, restaurant);
	}

	private FoodMenuDTO createFoodMenuDTO(List<FoodItem> foodItemList, RestaurantDTO restaurant) {
		FoodMenuDTO foodMenuDTO = new FoodMenuDTO();
		foodMenuDTO.setFoodItems(foodItemMapper.mapFoodItemsToFoodItemDTOs(foodItemList));
		foodMenuDTO.setRestaurant(restaurant);
		return foodMenuDTO;
	}

	private RestaurantDTO fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
		try {
			log.debug("Calling Restaurant Listing Service for restaurantId={}", restaurantId);
			ResponseEntity<RestaurantDTO> response = restTemplate.getForEntity(
					RESTAURANT_SERVICE_FETCH_BY_ID_URL,
					RestaurantDTO.class,
					restaurantId);
			return response.getBody();
		} catch (RestClientException ex) {
			log.error("Error while retrieving restaurant details for restaurantId={}", restaurantId, ex);
			throw new RestaurantServiceException(ERROR_RESTAURANT_SERVICE_UNAVAILABLE, ex);
		}
	}

	private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
		return foodItemRepository.findByRestaurantId(restaurantId);
	}

}
