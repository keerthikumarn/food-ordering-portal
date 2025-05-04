package com.order.management.service;

import com.order.management.dto.OrderDTO;
import com.order.management.dto.OrderRequestDTO;

public interface OrderService {

	public OrderDTO saveOrder(OrderRequestDTO orderDetails);
	
}
