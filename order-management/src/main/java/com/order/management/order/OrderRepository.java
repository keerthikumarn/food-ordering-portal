package com.order.management.order;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.order.management.entity.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, Integer>{

}
