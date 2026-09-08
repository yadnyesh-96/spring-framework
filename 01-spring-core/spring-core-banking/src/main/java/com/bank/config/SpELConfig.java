package com.bank.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpELConfig {

	@Value("#{bankingReportService.reportType}")
	private String reportType;

	public void printReportType() {
		System.out.println("Report Type is: " + reportType);
	}
}
