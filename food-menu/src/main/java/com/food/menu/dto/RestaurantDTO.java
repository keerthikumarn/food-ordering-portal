package com.food.menu.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO class for Restaurant entity.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDTO {

	@NotNull
	private Long id;

	@NotBlank
	private String name;

	@NotBlank
	private String address;

	@NotBlank
	private String city;

	private String description;

}
