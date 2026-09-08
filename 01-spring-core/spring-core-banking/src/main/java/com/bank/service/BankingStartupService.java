package com.bank.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class BankingStartupService {

	public BankingStartupService() {
		System.out.println("BankingStartupService Constructor");
	}

	@PostConstruct
	public void initialize() {
		System.out.println("@PostConstruct: Banking system initialized");
	}

	@PreDestroy
	public void cleanup() {
		System.out.println("@PreDestroy: Banking system shuting down");
	}
}
