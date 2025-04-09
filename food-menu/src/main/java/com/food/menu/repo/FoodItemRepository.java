package com.food.menu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.menu.entity.FoodItem;

/**
 * @Repository interface for FoodItem entity.
 */
public interface FoodItemRepository extends JpaRepository<FoodItem, Integer> {
	List<FoodItem> findByRestaurantId(Integer restaurantId);

}
