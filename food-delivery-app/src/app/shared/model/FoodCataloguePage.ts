import { FoodItem } from "./FoodItem";
import { Restaurant } from "./Restaurant";

export interface FoodMenu {
    foodItemsList:FoodItem[];
    restaurantDTO: Restaurant | null;
}
