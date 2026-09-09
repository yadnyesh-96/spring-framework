package com.inventory.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.inventory")
@Import(DatabaseConfig.class)
@EnableTransactionManagement
public class AppConfig {

}
