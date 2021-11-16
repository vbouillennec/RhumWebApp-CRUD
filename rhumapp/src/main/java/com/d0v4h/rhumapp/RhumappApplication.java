package com.d0v4h.rhumapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(CustomProperties.class)
public class RhumappApplication {
	// @Autowired
	// private CustomProperties properties;

	public static void main(String[] args) {
		SpringApplication.run(RhumappApplication.class, args);
	}
	
	// @Override
	// public void run(String... args) throws Exception {
	// 	// System.out.println("Test");
	// 	// System.out.println(properties.getApiUrl());
	// }

}
