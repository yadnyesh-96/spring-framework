package com.inventory.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.model.Order;
import com.inventory.model.OrderItem;
import com.inventory.repository.InventoryRepository;
import com.inventory.repository.OrderItemRepository;
import com.inventory.repository.OrderRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderService {

	private final OrderRepository orderRepository;
	private final OrderItemRepository orderItemRepository;
	private final InventoryRepository inventoryRepository;

	@Transactional
	public void placeOrder(Order order, OrderItem orderItem) {

		int orderId = orderRepository.createOrder(order);

		orderItem.setOrderId(orderId);

		boolean itemCreated = orderItemRepository.createOrderItem(orderItem);

		if (!itemCreated) {

			throw new RuntimeException("Failed to create order item");

		}

		boolean inventoryUpdate = inventoryRepository.reduceInventory(orderItem.getProductId(),
				orderItem.getQuantity());

		if (!inventoryUpdate) {
			throw new RuntimeException("Insufficient inventory");
		}

		System.out.println("Order Placed Successfully. Order ID: " + orderId);
	}
}
