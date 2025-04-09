package com.food.menu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemDTO {
	private int id;
	private String foodItemName;
	private String description;
	private boolean isVeg;
	private Long price;
	private Integer restaurantId;
	private Integer quantity;
}
