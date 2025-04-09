package com.food.menu.mapper;

import org.mapstruct.factory.Mappers;

import com.food.menu.dto.FoodItemDTO;
import com.food.menu.entity.FoodItem;

/**
 * This interface is used to map food items to their respective database
 * entities.
 */
public interface FoodItemMapper {

	FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

	FoodItem mapToFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);

	FoodItemDTO mapFoodItemToFoodItemDto(FoodItem foodItem);

}
