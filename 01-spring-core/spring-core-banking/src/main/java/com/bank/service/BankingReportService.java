package com.bank.service;

import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Lazy
@DependsOn("databaseInitializer")
public class BankingReportService {

	private String reportType = "MONTHLY";

	public BankingReportService() {
		System.out.println("BankingReportService Constructor");
	}

	@PostConstruct
	public void initialize() {
		System.out.println("BankingReportService @PostContruct");
	}

	public String getReportType() {
		return reportType;
	}

	public void generateReport() {
		System.out.println("Banking Report Generated");
	}
}
