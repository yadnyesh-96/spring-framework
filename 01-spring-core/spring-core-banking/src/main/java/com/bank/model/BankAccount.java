package com.bank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
	private String accountNumber;
	private String customerName;
	private String accountType;
	private double balance;
	private String status;

	@Override
	public String toString() {
		return "BankAccount{" + "accountNumber='" + accountNumber + '\'' + ", customerName='" + customerName + '\''
				+ ", accountType='" + accountType + '\'' + ", balance=" + balance + ", status='" + status + '\'' + '}';
	}
}
