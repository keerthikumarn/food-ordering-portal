package com.order.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemsDTO {

	private int id;
	private String itemName;
	private String description;
	private Boolean isVeg;
	private Long price;
	private Integer restaurantId;
	private Integer quantity;
}
