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
public class Order {

	private int orderId;
	private String customerName;
	private BigDecimal totalAmount;
	private String status;

	public Order(String customerName, BigDecimal totalAmount, String status) {
		this.customerName = customerName;
		this.totalAmount = totalAmount;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order{" + "orderId=" + orderId + ", customerName='" + customerName + '\'' + ", totalAmount="
				+ totalAmount + ", status='" + status + '\'' + '}';
	}
}
