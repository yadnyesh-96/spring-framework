package com.inventory.service;

import java.math.BigDecimal;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.model.Product;
import com.inventory.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Product findProductById(int productId) {

		try {
			return productRepository.findProductById(productId);
		} catch (EmptyResultDataAccessException e) {
			System.out.println("Product Not Found with Id: " + productId);
			return null;
		}

	}

	// transactional
//
//	@Transactional
//	public void testTransaction() {
//
//		Product product1 = new Product(1, "Rollback Laptop", "ELECTRONICS", new BigDecimal("81000"), "ACTIVE");
//
//		Product product2 = new Product(2, "Rollback Mouse", "ACCESSORIES", new BigDecimal("1600"), "ACTIVE");
//
//		productRepository.updateProduct(product1);
//
//		// Intentionally cause an exception
//		throw new RuntimeException("Something went wrong!");
//	}
}
