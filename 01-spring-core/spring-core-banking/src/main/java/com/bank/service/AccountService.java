package com.bank.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bank.model.BankAccount;
import com.bank.notification.NotificationService;
import com.bank.repository.AccountRepository;

@Service
public class AccountService {

	AccountRepository accRepo;
	NotificationService notificationService;

	public AccountService(AccountRepository accRepo,
			@Qualifier("emailNotificationService") 
			NotificationService notificationService) {
		
		this.accRepo = accRepo;
		this.notificationService = notificationService;
	}

	public boolean createAccount(BankAccount acc) {
		return accRepo.createAccount(acc);
	}

	public BankAccount findByAccountNumber(String accountNumber) {
		return accRepo.findByAccountNumber(accountNumber);
	}

	public boolean updateAccount(BankAccount a) {
		return accRepo.updateAccount(a);
	}

	public boolean deleteAccount(String accountNumber) {
		return accRepo.deleteAccount(accountNumber);
	}

	public void sendNotification() {
		notificationService.sendNotification("Bank Account operation completes");
	}
}
