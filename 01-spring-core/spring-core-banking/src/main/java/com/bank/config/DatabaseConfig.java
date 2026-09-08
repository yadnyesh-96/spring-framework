package com.bank.config;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:database.properties")
public class DatabaseConfig {

	@Value("${db.url}")
	private String url;

	@Value("${db.username}")
	private String username;

	@Value("${db.password}")
	private String password;

	@Value("${db.driver}")
	private String driver;

	@Bean
	public Connection getConnection() {

		try {
			Class.forName(driver);

			return DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {

			throw new RuntimeException("JDBC Driver not found: " + driver, e);

		} catch (Exception e) {

			throw new RuntimeException("Failed to create database connection", e);
		}
	}

}
