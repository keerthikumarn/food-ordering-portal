package com.order.management.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.order.management.dto.FoodItemsDTO;
import com.order.management.dto.RestaurantDTO;
import com.order.management.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {

	 private Integer orderId;
	    private List<FoodItemsDTO> foodItemsList;
	    private RestaurantDTO restaurant;
	    private UserDTO userDTO;
}
