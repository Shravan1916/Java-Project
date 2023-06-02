package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"com.model","com.controller","com.dao"," com.example", "com.services"})
@EntityScan("com.model")
@EnableJpaRepositories(basePackages = "com.dao")
@SpringBootApplication
public class EmployeeManagementBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementBackendApplication.class, args);
	}

}
