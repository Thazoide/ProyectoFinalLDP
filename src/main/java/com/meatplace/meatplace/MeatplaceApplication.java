package com.meatplace.meatplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "com.meatplace.meatplace.entidades" })
@EnableJpaRepositories(basePackages = { "com.meatplace.meatplace.repositorio" })
@ComponentScan(basePackages = { 
    "com.meatplace.meatplace.controladores", 
    "com.meatplace.meatplace.services" 
})
public class MeatplaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeatplaceApplication.class, args);
	}

}
