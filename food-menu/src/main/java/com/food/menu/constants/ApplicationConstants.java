package com.food.menu.constants;

/**
 * Central place for application-wide constants to avoid hard-coded values
 * scattered across the codebase.
 */
public final class ApplicationConstants {

    private ApplicationConstants() {
        // Utility class
    }

    // API paths
    public static final String API_V1_BASE_PATH = "/api/v1";
    public static final String FOOD_MENU_BASE_PATH = API_V1_BASE_PATH + "/foodmenu";
    public static final String ADD_FOOD_ITEM_PATH = "/food-items";
    public static final String RESTAURANT_MENU_BY_ID_PATH = "/restaurants/{restaurantId}/menu";

    // External service identifiers and URLs
    public static final String RESTAURANT_SERVICE_NAME = "RESTAURANT-LISTING-SERVICE";
    public static final String RESTAURANT_SERVICE_FETCH_BY_ID_URL =
            "http://" + RESTAURANT_SERVICE_NAME + "/restaurant/fetchById/{restaurantId}";

    // Error messages / codes
    public static final String ERROR_RESTAURANT_SERVICE_UNAVAILABLE =
            "Failed to fetch restaurant details from Restaurant Listing Service";
    public static final String ERROR_FOOD_ITEMS_NOT_FOUND =
            "No food items found for the given restaurant";

    // RestTemplate configuration
    public static final int REST_TEMPLATE_CONNECT_TIMEOUT_MILLIS = 2000;
    public static final int REST_TEMPLATE_READ_TIMEOUT_MILLIS = 5000;

}

