package com.todenterprises.wyaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication (scanBasePackages = {"com.todenterprises.wyaapp.controllers", "com.todenterprises.wyaapp.services", "com.todenterprises.wyaapp.cronjobs"})
@EnableScheduling
public class WyaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WyaAppApplication.class, args);
	}

}