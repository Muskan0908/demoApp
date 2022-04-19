package com.cg.nutritionapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.cg.nutritionapp"})
@SpringBootApplication
public class NutritionAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(NutritionAppApplication.class, args);
	}

}
