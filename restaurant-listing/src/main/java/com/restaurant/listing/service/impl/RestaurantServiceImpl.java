package com.restaurant.listing.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.listing.dto.RestaurantDTO;
import com.restaurant.listing.entity.Restaurant;
import com.restaurant.listing.mapper.RestaurantMapper;
import com.restaurant.listing.repo.RestaurantRepository;
import com.restaurant.listing.service.RestaurantService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepo;

	@Override
	public List<RestaurantDTO> findAllRestaurants() {
		log.info("RestaurantServiceImpl - findAllRestaurants() called");
		List<Restaurant> restaurantsList = restaurantRepo.findAll();
		if (restaurantsList == null || restaurantsList.isEmpty()) {
			log.warn("RestaurantServiceImpl - No restaurants found in the database");
			return null;
		}
		List<RestaurantDTO> restaurantDtoList = null;
		if (restaurantsList != null && !restaurantsList.isEmpty()) {
			restaurantDtoList = restaurantsList.stream()
					.map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant))
					.collect(Collectors.toList());
		}
		log.info("RestaurantServiceImpl - Found {} restaurants", restaurantDtoList.size());
		return restaurantDtoList;
	}

	@Override
	public RestaurantDTO saveRestaurant(RestaurantDTO restaurantDTO) {
		log.info("RestaurantServiceImpl - saveRestaurant() called for restaurant: {}", restaurantDTO.getName());
		Restaurant restaurant = restaurantRepo
				.save(RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDTO));
		log.info("RestaurantServiceImpl - Restaurant saved with ID: {}", restaurant.getId());
		return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant);
	}

	@Override
	public RestaurantDTO fetchRestaurantById(Integer id) {
		log.info("RestaurantServiceImpl - fetchRestaurantById() called for ID: {}", id);
		Optional<Restaurant> restaurant = restaurantRepo.findById(id);
		if (restaurant.isPresent()) {
			log.info("RestaurantServiceImpl - Restaurant found for ID: {}", id);
			return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant.get());
		} else {
			log.warn("RestaurantServiceImpl - No restaurant found for ID: {}", id);
			return null;
		}
	}

}
