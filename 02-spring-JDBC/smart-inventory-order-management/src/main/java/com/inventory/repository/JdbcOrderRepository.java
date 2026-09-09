package com.inventory.repository;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.inventory.model.Order;

@Repository
public class JdbcOrderRepository implements OrderRepository {

	private final NamedParameterJdbcTemplate namedParameterJdbctTemplate;

	public JdbcOrderRepository(NamedParameterJdbcTemplate namedParameterJdbctTemplate) {
		this.namedParameterJdbctTemplate = namedParameterJdbctTemplate;
	}

	@Override
	public int createOrder(Order order) {

		MapSqlParameterSource param = new MapSqlParameterSource().addValue("customerName", order.getCustomerName())
				.addValue("totalAmount", order.getTotalAmount()).addValue("status", order.getStatus());

		KeyHolder keyHolder = new GeneratedKeyHolder();

		namedParameterJdbctTemplate.update(
				"INSERT INTO orders (customer_name, total_amount, status) VALUES (:customerName,:totalAmount,:status)",
				param, keyHolder, new String[] { "order_id" });

		return keyHolder.getKey().intValue();
	}

}
