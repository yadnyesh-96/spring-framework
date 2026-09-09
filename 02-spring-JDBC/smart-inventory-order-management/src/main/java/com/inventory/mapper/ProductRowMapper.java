package com.inventory.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.inventory.model.Product;

public class ProductRowMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

		Product p = new Product();

		p.setProductId(rs.getInt("product_id"));

		p.setProductName(rs.getString("product_name"));

		p.setCategory(rs.getString("category"));

		p.setPrice(rs.getBigDecimal("price"));

		p.setStatus(rs.getString("status"));

		return p;
	}
}