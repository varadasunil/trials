package com.microservice.order.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.microservice.order.dto.OrderLineItemsDto;
import com.microservice.order.dto.OrderRequest;
import com.microservice.order.model.Order;
import com.microservice.order.model.OrderLineItems;
import com.microservice.order.repo.OrderRepo;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class OrderService {
	
	private final OrderRepo orderRepo;
	public void placeOrder(OrderRequest orderRequest) {
		
		Order order=new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		List<OrderLineItems> orderLineItems=orderRequest.getOrderLineItemsDtoList()
				.stream().map(this::mapToDto).toList();
		
		order.setOrderLineItemsList(orderLineItems);
		orderRepo.save(order);
	}
	
	
	public OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
		
		OrderLineItems orderLineItems =new OrderLineItems();
		orderLineItems.setPrice(orderLineItemsDto.getPrice());
		orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
		orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
		return orderLineItems;


}
}