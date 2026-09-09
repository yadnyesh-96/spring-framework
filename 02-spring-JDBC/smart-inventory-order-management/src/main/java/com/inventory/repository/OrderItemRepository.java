package com.inventory.repository;

import com.inventory.model.OrderItem;

public interface OrderItemRepository {

	boolean createOrderItem(OrderItem orderitem);
}
