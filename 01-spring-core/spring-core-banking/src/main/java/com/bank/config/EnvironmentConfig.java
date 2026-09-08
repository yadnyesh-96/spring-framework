package com.bank.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class EnvironmentConfig {

	private final Environment environment;

	public EnvironmentConfig(Environment environment) {
		this.environment = environment;
	}

	public void printDatabaseProperties() {
		System.out.println("DB URL: " + environment.getProperty("db.url"));
		System.out.println("DB Username: " + environment.getProperty("db.username"));
		System.out.println("DB Driver: " + environment.getProperty("db.driver"));
	}
}
