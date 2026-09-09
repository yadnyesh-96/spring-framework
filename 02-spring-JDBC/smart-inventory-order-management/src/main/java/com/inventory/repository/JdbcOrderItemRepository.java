package com.inventory.repository;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inventory.model.OrderItem;

@Repository
public class JdbcOrderItemRepository implements OrderItemRepository {

	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	JdbcOrderItemRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public boolean createOrderItem(OrderItem orderitem) {

		MapSqlParameterSource param = new MapSqlParameterSource().addValue("orderId", orderitem.getOrderId())
				.addValue("productId", orderitem.getProductId()).addValue("quantity", orderitem.getQuantity())
				.addValue("unitPrice", orderitem.getUnitPrice());

		return namedParameterJdbcTemplate.update(
				"INSERT INTO order_items (order_id, product_id, quantity, unit_price) VALUES (:orderId, :productId, :quantity, :unitPrice)",
				param) > 0;
	}

}
