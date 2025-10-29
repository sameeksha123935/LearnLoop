package com.learnloop.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnLoopApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnLoopApplication.class, args);
		System.out.println("✅ LearnLoop Backend Running at http://localhost:8080");
	}

}
