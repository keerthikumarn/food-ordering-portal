package com.food.menu;

import static com.food.menu.constants.ApplicationConstants.REST_TEMPLATE_CONNECT_TIMEOUT_MILLIS;
import static com.food.menu.constants.ApplicationConstants.REST_TEMPLATE_READ_TIMEOUT_MILLIS;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FoodMenuApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodMenuApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder
				.setConnectTimeout(Duration.ofMillis(REST_TEMPLATE_CONNECT_TIMEOUT_MILLIS))
				.setReadTimeout(Duration.ofMillis(REST_TEMPLATE_READ_TIMEOUT_MILLIS))
				.build();
	}

}

