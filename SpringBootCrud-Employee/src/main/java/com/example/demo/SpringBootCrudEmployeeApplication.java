package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.crud.*")
@EnableJpaRepositories("com.crud.*")
@EntityScan("com.crud.*")
@EnableCaching
public class SpringBootCrudEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudEmployeeApplication.class, args);
	}

}
