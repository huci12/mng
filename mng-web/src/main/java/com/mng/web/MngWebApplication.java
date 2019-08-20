package com.mng.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.mng.*")
public class MngWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(MngWebApplication.class, args);
	}
}
