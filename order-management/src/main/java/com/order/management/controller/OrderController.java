package com.order.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.management.dto.OrderDTO;
import com.order.management.dto.OrderRequestDTO;
import com.order.management.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/save")
	public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderRequestDTO orderDetails) {
		log.info("OrderController - saveOrder() called with order details: {}", orderDetails);
		OrderDTO orderSavedInDB = orderService.saveOrder(orderDetails);
		log.info("OrderController - Order saved successfully with ID: {}", orderSavedInDB.getOrderId());
		return new ResponseEntity<>(orderSavedInDB, HttpStatus.CREATED);
	}
}
