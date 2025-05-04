package com.order.management.mapper;

import org.mapstruct.factory.Mappers;

import com.order.management.dto.OrderDTO;
import com.order.management.entity.Order;

public interface OrderMapper {

	OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

	Order mapOrderDTOToOrder(OrderDTO orderDTO);

	OrderDTO mapOrderToOrderDTO(Order order);
}
