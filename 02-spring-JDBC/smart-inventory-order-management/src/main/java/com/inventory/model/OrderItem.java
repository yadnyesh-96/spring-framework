
package com.inventory.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

	private int orderItemId;
	private int orderId;
	private int productId;
	private int quantity;
	private BigDecimal unitPrice;

	public OrderItem(int orderId, int productId, int quantity, BigDecimal unitPrice) {
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "OrderItem{" + "orderItemId=" + orderItemId + ", orderId=" + orderId + ", productId=" + productId
				+ ", quantity=" + quantity + ", unitPrice=" + unitPrice + '}';
	}
}
