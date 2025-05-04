package com.example.urlshortnering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
public class UrlShortneringApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlShortneringApplication.class, args);
	}

}
