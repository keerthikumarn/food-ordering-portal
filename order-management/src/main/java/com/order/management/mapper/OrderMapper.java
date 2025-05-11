package com.order.management.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.order.management.dto.OrderDTO;
import com.order.management.entity.Order;

@Mapper
public interface OrderMapper {

	OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

	Order mapOrderDTOToOrder(OrderDTO orderDTO);

	OrderDTO mapOrderToOrderDTO(Order order);
}
