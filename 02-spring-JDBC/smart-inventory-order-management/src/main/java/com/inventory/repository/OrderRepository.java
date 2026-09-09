package com.inventory.repository;

import com.inventory.model.Order;

public interface OrderRepository {

	int createOrder(Order order);
}
