package com.bank.config;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component("databaseInitializer")
public class BankingDatabaseInitializer {

	public BankingDatabaseInitializer() {
		System.out.println("DatabaseInitializer Contructor");
	}

	@PostConstruct
	public void initialize() {
		System.out.println("DatabaseInitializer @PostContruct");
	}
}
