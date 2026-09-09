package com.inventory.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	private int productId;
	private String productName;
	private String category;
	private BigDecimal price;
	private String status;

	public Product(String productName, String category, BigDecimal price, String status) {
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.status = status;
	}
}
