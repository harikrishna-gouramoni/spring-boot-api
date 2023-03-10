package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootApiApplication {

	@GetMapping("/")
	public String getMessage() {
		return "<h2>Hello, Spring Boot!</h2>";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiApplication.class, args);
	}

	 
}
