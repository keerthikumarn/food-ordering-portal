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

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepo;

	/*@Override
	public List<RestaurantDTO> findAllRestaurants() {
		List<Restaurant> restaurantsList = restaurantRepo.findAll();
		List<RestaurantDTO> restaurantDtoList = null;
		if (restaurantsList != null && !restaurantsList.isEmpty()) {
			restaurantDtoList = restaurantsList.stream()
					.map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant))
					.collect(Collectors.toList());
		}
		return restaurantDtoList;
	}*/
	
	@Override
	public List<RestaurantDTO> findAllRestaurants() {
		List<RestaurantDTO> restaurantsList = restaurantRepo.findAll().stream()
				.map(RestaurantMapper.INSTANCE::mapRestaurantToRestaurantDTO)
				.collect(Collectors.toList());
		return restaurantsList;
	}

	@Override
	public RestaurantDTO saveRestaurant(RestaurantDTO restaurantDTO) {
		Restaurant restaurant = restaurantRepo
				.save(RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDTO));
		return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant);
	}

	@Override
	public RestaurantDTO fetchRestaurantById(Integer id) {
		Optional<Restaurant> restaurant = restaurantRepo.findById(id);
		if (restaurant.isPresent()) {
			return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant.get());
		}
		return null;
	}

}
