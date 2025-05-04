package com.order.management.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {
	
	public List<FoodItemsDTO> foodItemsList;
	private Integer userId;
	private RestaurantDTO restaurant;

}
