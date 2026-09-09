package com.inventory.repository;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcInventoryRepository implements InventoryRepository {

	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public JdbcInventoryRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public boolean reduceInventory(int productId, int quantity) {
		MapSqlParameterSource parameter = new MapSqlParameterSource().addValue("productId", productId)
				.addValue("quantity", quantity);
		int row = namedParameterJdbcTemplate.update(
				"UPDATE inventory SET quantity=quantity-:quantity 	WHERE product_id=:productId AND quantity>=:quantity",
				parameter);

		System.out.println("Inventory rows updated: " + row);

		return row > 0;
	}
}
