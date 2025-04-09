package com.food.menu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemDTO {
	private int id;
	private String itemName;
	private String itemDescription;
	@JsonProperty("isVeg")
	private boolean isVeg;
	private Long price;
	private Integer restaurantId;
	private Integer quantity;
}
