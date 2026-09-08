package com.bank.repository;

import com.bank.model.BankAccount;

public interface AccountRepository {

	// Create new Fresh Bank Account
	public boolean createAccount(BankAccount acc);

	// To find the my existing account using account number
	public BankAccount findByAccountNumber(String accountNumber);

	// Update Account Details
	public boolean updateAccount(BankAccount account);

	// Delete Remove or Status = Active -> DeActive Account
	public boolean deleteAccount(String accountNumber);

}
