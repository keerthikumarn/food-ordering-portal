package com.food.menu.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemDTO {
	private int id;

	@NotBlank
	private String foodItemName;

	private String description;

	@NotNull
	private Boolean isVeg;

	@NotNull
	@Min(0)
	private Long price;

	@NotNull
	private Integer restaurantId;

	@NotNull
	@Min(0)
	private Integer quantity;
}
