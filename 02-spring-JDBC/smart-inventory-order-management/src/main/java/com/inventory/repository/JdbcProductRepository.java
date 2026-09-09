package com.inventory.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.inventory.mapper.ProductRowMapper;
import com.inventory.model.Product;

@Repository
public class JdbcProductRepository implements ProductRepository {

	private final JdbcTemplate jdbcTemplate;
	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public JdbcProductRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;

	}

	@Override
	public boolean createProduct(Product product) {

		String sql = "INSERT INTO products (product_name, category, price, status) VALUES (?, ?, ?, ?)";

		int rows = jdbcTemplate.update(sql, product.getProductName(), product.getCategory(), product.getPrice(),
				product.getStatus());

		return rows > 0;
	}

	@Override
	public Product findProductById(int productId) {

		return jdbcTemplate.queryForObject(
				"SELECT product_id, product_name, category, price, status FROM products WHERE product_id=?",
				new ProductRowMapper(), productId);
	}

	@Override
	public List<Product> findAllProducts() {
		return jdbcTemplate.query("SELECT *FROM products", new ProductRowMapper());
	}

	@Override
	public boolean updateProduct(Product product) {

		String sql = "UPDATE products SET product_name=?, category=?, price=?, status=? WHERE product_id=?";
		int row = jdbcTemplate.update(sql, product.getProductName(), product.getCategory(), product.getPrice(),
				product.getStatus(), product.getProductId());

		return row > 0;
	}

	@Override
	public boolean deleteProduct(int productId) {

		int row = jdbcTemplate.update("DELETE FROM products WHERE product_id= ?", productId);
		return row > 0;
	}

	@Override
	public List<Product> findProductsByStatus(String status) {

		return jdbcTemplate.query(
				"SELECT product_id, product_name, category, price, status FROM products WHERE status=?",
				new ProductRowMapper(), status);
	}

	@Override
	public List<Product> findProductsByCategory(String category) {

		return jdbcTemplate.query(
				"SELECT product_id, product_name, category, price, status FROM products WHERE category=?",
				new ProductRowMapper(), category);
	}

	@Override
	public List<Product> findProductsByCategoryAndMaxPrice(String category, BigDecimal maxPrice) {
		return jdbcTemplate.query(
				"SELECT product_id, product_name, category, price, status FROM products WHERE category=? AND price<=?",
				new ProductRowMapper(), category, maxPrice);
	}

	@Override
	public List<Product> searchProductsByName(String keyword) {
		return jdbcTemplate.query(
				"SELECT product_id, product_name, category, price, status FROM products WHERE product_name LIKE ?",
				new ProductRowMapper(), "%" + keyword + "%");
	}

	@Override
	public List<Product> findProductByCategoryAndPrice(String category, BigDecimal maxPrice) {
		MapSqlParameterSource parameter = new MapSqlParameterSource().addValue("category", category)
				.addValue("maxPrice", maxPrice);

		return namedParameterJdbcTemplate.query(
				"SELECT product_id, product_name, category, price, status FROM products WHERE category=:category AND price<=:maxPrice",
				parameter, new ProductRowMapper());
	}

	@Override
	public boolean createProductWithNamedParameters(Product product) {
		MapSqlParameterSource parameter = new MapSqlParameterSource().addValue("product_name", product.getProductName())
				.addValue("category", product.getCategory()).addValue("price", product.getPrice())
				.addValue("status", product.getStatus());
		return namedParameterJdbcTemplate.update(
				"INSERT INTO products (product_name, category, price, status) VALUES (:product_name, :category, :price, :status)",
				parameter) > 0;
	}

	@Override
	public int createProductAndReturnId(Product product) {

		String sql = "INSERT INTO products (product_name, category, price, status) VALUES (:productName, :category, :price, :status)";

		MapSqlParameterSource params = new MapSqlParameterSource().addValue("productName", product.getProductName())
				.addValue("category", product.getCategory()).addValue("price", product.getPrice())
				.addValue("status", product.getStatus());

		KeyHolder keyHolder = new GeneratedKeyHolder();

		namedParameterJdbcTemplate.update(sql, params, keyHolder, new String[] { "product_id" });

		return keyHolder.getKey().intValue();
	}

	@Override
	public int[] createProductsInBatch(List<Product> products) {

		List<Object[]> batch = new ArrayList<>();

		for (Product p : products) {
			Object[] values = { p.getProductName(), p.getCategory(), p.getPrice(), p.getStatus() };
			batch.add(values);
		}
		return jdbcTemplate.batchUpdate("INSERT INTO products (product_name, category, price, status) VALUES (?,?,?,?)",
				batch);
	}

}
