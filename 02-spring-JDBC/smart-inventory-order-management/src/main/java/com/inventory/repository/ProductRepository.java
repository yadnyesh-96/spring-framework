package com.inventory.repository;

import java.math.BigDecimal;
import java.util.List;

import com.inventory.model.Product;

public interface ProductRepository {

	boolean createProduct(Product product);

	Product findProductById(int productId);

	List<Product> findAllProducts();

	boolean updateProduct(Product product);

	boolean deleteProduct(int productId);

	List<Product> findProductsByStatus(String status);

	List<Product> findProductsByCategory(String category);

	List<Product> findProductsByCategoryAndMaxPrice(String category, BigDecimal maxPrice);

	List<Product> searchProductsByName(String keyword);

	// Named Parameter JdbcTemplate

	List<Product> findProductByCategoryAndPrice(String category, BigDecimal maxPrice);

	boolean createProductWithNamedParameters(Product product);

	int createProductAndReturnId(Product product);

	// Batch Update
	int[] createProductsInBatch(List<Product> products);

	// Pagination
	List<Product> findProductByPage(int PageNumber, int PageSize);
}
