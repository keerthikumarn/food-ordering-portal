package com.food.menu.exception;

/**
 * Exception thrown when the Restaurant Listing Service cannot be reached
 * or returns an unexpected response.
 */
public class RestaurantServiceException extends RuntimeException {

    public RestaurantServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}

