package com.food.menu.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.food.menu.dto.FoodItemDTO;
import com.food.menu.entity.FoodItem;

import java.util.List;

/**
 * Maps between food item DTOs and JPA entities.
 */
@Mapper(componentModel = "spring")
public interface FoodItemMapper {

	FoodItem mapToFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);

	FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem);

	List<FoodItemDTO> mapFoodItemsToFoodItemDTOs(List<FoodItem> foodItems);

}
