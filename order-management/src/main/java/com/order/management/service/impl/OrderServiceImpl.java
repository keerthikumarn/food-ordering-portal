package com.order.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.management.dto.OrderDTO;
import com.order.management.dto.OrderRequestDTO;
import com.order.management.dto.UserDTO;
import com.order.management.entity.Order;
import com.order.management.mapper.OrderMapper;
import com.order.management.order.OrderRepository;
import com.order.management.service.OrderService;
import com.order.management.service.SequenceGenService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private SequenceGenService seqGenService;

	@Override
	public OrderDTO saveOrder(OrderRequestDTO orderDetails) {
		Integer newOrderId = seqGenService.generateNextOrderId();
		UserDTO userDto = fetchUserDetailsFromUserId(orderDetails.getUserId());
		Order orderToBeSaved = new Order(newOrderId, orderDetails.getFoodItemsList(), orderDetails.getRestaurant(),
				userDto);
		orderRepo.save(orderToBeSaved);
		return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);
	}

	private UserDTO fetchUserDetailsFromUserId(Integer userId) {
		return restTemplate.getForObject("http://USER-MANAGEMENT-SERVICE/user/fetchUserById/" + userId, UserDTO.class);
	}

}
