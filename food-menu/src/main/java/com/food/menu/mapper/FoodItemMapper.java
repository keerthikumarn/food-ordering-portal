package com.food.menu.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.food.menu.dto.FoodItemDTO;
import com.food.menu.entity.FoodItem;

/**
 * This interface is used to map food items to their respective database
 * entities.
 */
@Mapper
public interface FoodItemMapper {

	FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

	FoodItem mapToFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);

	FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem);

}
