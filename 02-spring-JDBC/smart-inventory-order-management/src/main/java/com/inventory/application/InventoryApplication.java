package com.inventory.application;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.inventory.config.AppConfig;
import com.inventory.config.DatabaseConfig;
import com.inventory.model.Product;
import com.inventory.repository.ProductRepository;
import com.inventory.service.ProductService;

public class InventoryApplication {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		ProductRepository repository = context.getBean(ProductRepository.class);

		/*
		 * Product p = new Product("Laptop Stand", "ACCESSORIES", new
		 * BigDecimal("1800.00"), "ACTIVE");
		 * 
		 * System.out.println(repository.createProduct(p) ? "Product Added" :
		 * "Fail to add Product");
		 */

		/*
		 * Product p = repository.findProductById(1);
		 * System.out.println(p.getProductId() + "\t" + p.getProductName() + "\t" +
		 * p.getCategory() + "\t" + p.getPrice());
		 */

		/*
		 * List<Product> p = repository.findAllProducts();
		 * 
		 * for (Product k : p) { System.out.println(k.getProductId() + "\t" +
		 * k.getProductName() + "\t\t\t" + k.getCategory() + "\t" + k.getPrice() + "\t"
		 * + k.getStatus()); }
		 */

		/*
		 * Product product = new Product(1, "Gaming Laptop", "ELECTRONICS", new
		 * BigDecimal("75000"), "ACTIVE");
		 * 
		 * boolean updated = repository.updateProduct(product);
		 * 
		 * System.out.println("Product updated: " + updated);
		 * 
		 * Product p = repository.findProductById(1);
		 * 
		 * System.out.println(p.getProductId() + "\t" + p.getProductName() + "\t" +
		 * p.getCategory() + "\t" + p.getPrice());
		 */

//		System.out.println(repository.deleteProduct(6) ? "Product Deleted" : "Fail to Delete the Product");

		List<Product> p = repository.findProductsByStatus("ACTIVE");

		/*
		 * for (Product k : p) { System.out.println(k.getProductId() + "\t" +
		 * k.getProductName() + "\t\t\t" + k.getCategory() + "\t" + k.getPrice() + "\t"
		 * + k.getStatus()); }
		 */

//		List<Product> c = repository.findProductsByCategory("ACCESSORIES");
//		List<Product> c = repository.findProductsByCategoryAndMaxPrice("ACCESSORIES", new BigDecimal("3000"));
//		List<Product> c = repository.searchProductsByName("Laptop");
		/*
		 * List<Product> c = repository.findProductByCategoryAndPrice("ACCESSORIES", new
		 * BigDecimal("3000")); for (Product k : c) {
		 * System.out.println(k.getProductId() + "\t" + k.getProductName() + "\t\t\t" +
		 * k.getCategory() + "\t" + k.getPrice() + "\t" + k.getStatus()); }
		 * 
		 * System.out.println("END");
		 * 
		 * Product product = new Product("Bluetooth Speaker", "ELECTRONICS", new
		 * BigDecimal("3500"), "ACTIVE");
		 * 
		 * boolean created = repository.createProductWithNamedParameters(product);
		 * 
		 * System.out.println("Product created: " + created);
		 * 
		 * Product pr = new Product("Smart Watch", "ELECTRONICS", new
		 * BigDecimal("5500"), "ACTIVE");
		 * 
		 * int generatedId = repository.createProductAndReturnId(pr);
		 * 
		 * System.out.println("Generated Product ID: " + generatedId);
		 * 
		 * List<Product> products = List.of(
		 * 
		 * new Product("Laptop Stand", "ACCESSORIES", new BigDecimal("1500"), "ACTIVE"),
		 * 
		 * new Product("Webcam", "ELECTRONICS", new BigDecimal("3000"), "ACTIVE"),
		 * 
		 * new Product("Headphones", "ELECTRONICS", new BigDecimal("2500"), "ACTIVE"));
		 * 
		 * int[] result = repository.createProductsInBatch(products);
		 * 
		 * System.out.println(Arrays.toString(result));
		 */

		/*
		 * try { Product pp = repository.findProductById(9999); System.out.println(pp);
		 * } catch (EmptyResultDataAccessException e) {
		 * System.out.println("Product not found"); }
		 */

		ProductService productService = context.getBean(ProductService.class);

		Product l = productService.findProductById(999);
		if (l != null) {
			System.out.println(l.getProductId() + "\t" + l.getProductName() + "\t" + l.getCategory() + "\t"
					+ l.getPrice() + "\t" + l.getStatus());
		} else {
			System.out.println("No product returned.");
		}
		productService.testTransaction();

	}

}
