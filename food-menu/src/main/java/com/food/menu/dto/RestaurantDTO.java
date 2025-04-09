package com.food.menu.dto;

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

	private Long id;
	private String name;
	private String address;
	private String city;
	private String description;

}
