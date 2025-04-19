package com.restaurant.listing.service;

import java.util.List;

import com.restaurant.listing.dto.RestaurantDTO;

public interface RestaurantService {

	public List<RestaurantDTO> findAllRestaurants();

	public RestaurantDTO saveRestaurant(RestaurantDTO restaurantDTO);

	public RestaurantDTO fetchRestaurantById(Integer id);

}
