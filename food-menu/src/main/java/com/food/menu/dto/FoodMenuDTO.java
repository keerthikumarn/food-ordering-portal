package com.food.menu.dto;

import java.util.List;

import com.food.menu.entity.FoodItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodMenuDTO {

	private List<FoodItem> foodItemsList;
	private RestaurantDTO restaurantDTO;
	
}
