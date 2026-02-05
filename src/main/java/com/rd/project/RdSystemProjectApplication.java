package com.rd.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RdSystemProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RdSystemProjectApplication.class, args);
		System.out.println("success......");
	}

	@org.springframework.context.annotation.Bean
	public org.springframework.boot.CommandLineRunner debugDataSource(
			@org.springframework.beans.factory.annotation.Value("${spring.datasource.url}") String url) {
		return args -> {
			System.out.println("==========================================");
			System.out.println("DEBUG: ACTIVE DATASOURCE URL IS: " + url);
			System.out.println("==========================================");
		};
	}

}
