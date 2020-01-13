package com.todenterprises.wyaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = {"com.todenterprises.wyaapp.controllers"})
public class WyaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WyaAppApplication.class, args);
	}

}