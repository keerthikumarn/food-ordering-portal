package com.food.menu.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodMenuDTO {

	private List<FoodItemDTO> foodItems;
	private RestaurantDTO restaurant;

}

