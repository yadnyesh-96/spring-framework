package com.bank.Test;

import java.sql.Connection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bank.config.AppConfig;
import com.bank.config.DatabaseConfig;
import com.bank.config.EnvironmentConfig;
import com.bank.config.SpELConfig;
import com.bank.model.BankAccount;
import com.bank.service.AccountService;
import com.bank.service.BankingReportService;

public class BankApplicaion {

	public static void main(String[] args) {

		BankAccount acc = new BankAccount("ACC1001", "Yadnyesh", "SAVINGS", 50000, "ACTIVE");
		System.out.println(acc);

		// 1. Start Spring IoC Container
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// 2. Get AccountService bean from Spring
		AccountService accountService = context.getBean(AccountService.class);
		accountService.sendNotification();

		/*
		 * // 3. Create BankAccount object BankAccount account = new
		 * BankAccount("ACC1004", "Amit", "SAVINGS", 60000.00, "ACTIVE");
		 * 
		 * // 4. Call service boolean result = accountService.createAccount(account);
		 * 
		 * // 5. Check result if (result) {
		 * System.out.println("Account created successfully!"); } else {
		 * System.out.println("Account creation failed!"); }
		 */

		/*
		 * BankAccount bA = accountService.findByAccountNumber("ACC1004");
		 * 
		 * System.out.println(bA);
		 * 
		 * BankAccount account = new BankAccount("ACC1004", "Amit Sharma", "SAVINGS",
		 * 75000.00, "ACTIVE");
		 * 
		 * System.out.println(accountService.updateAccount(account) ? "Account Updated"
		 * : "Updation Failed");
		 */
		/*
		 * System.out.println(accountService.deleteAccount("ACC1004") ?
		 * "Account Deleted" : "Failed to delete account");
		 */

		BankingReportService reports = context.getBean(BankingReportService.class);
		reports.generateReport();

		EnvironmentConfig environmentConfig = context.getBean(EnvironmentConfig.class);

		environmentConfig.printDatabaseProperties();

		SpELConfig spelConfig = context.getBean(SpELConfig.class);

		spelConfig.printReportType();

		context.close();

	}

}
