package com.project.shortening_url;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ShorteningUrlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShorteningUrlApplication.class, args);
	}

}
