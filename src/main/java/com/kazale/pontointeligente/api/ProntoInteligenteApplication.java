package com.kazale.pontointeligente.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ProntoInteligenteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProntoInteligenteApplication.class, args);
	}
}
