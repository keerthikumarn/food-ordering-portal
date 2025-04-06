package com.food.menu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.food.menu.*"})
public class FoodMenuApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodMenuApplication.class, args);
	}

	/*@GetMapping("/hi")
	public String printMessage() {
		return "Welcome to Food Ordering Application !!";
	}*/
}
