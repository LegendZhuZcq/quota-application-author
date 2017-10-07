package com.quoteservice.author;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthorApplication {

	@Autowired
	private AuthorData authorData;
	
	public static void main(String[] args) {
		SpringApplication.run(AuthorApplication.class, args);
	}
}
