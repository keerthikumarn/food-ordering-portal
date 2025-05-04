package com.order.management;

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

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/save")
	public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderRequestDTO orderDetails) {
		OrderDTO orderSavedInDB = orderService.saveOrder(orderDetails);
		return new ResponseEntity<>(orderSavedInDB, HttpStatus.CREATED);
	}
}
