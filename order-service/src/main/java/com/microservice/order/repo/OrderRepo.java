package com.microservice.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.order.model.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {

}
