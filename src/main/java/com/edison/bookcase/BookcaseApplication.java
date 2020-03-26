package com.edison.bookcase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BookcaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookcaseApplication.class, args);
	}

}
