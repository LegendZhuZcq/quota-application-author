package com.quoteservice.author;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.quoteservice.author.service.AuthorService;
import com.quoteservice.author.model.Author;

@Configuration
public class AuthorData {

	@Autowired
	private AuthorService authorService;
	
	private static final Logger log = LoggerFactory.getLogger(AuthorData.class);
	
	@Bean
	public AuthorData getBean() throws SQLException{
		Author a1 = new Author("Douglas Adams");
		Author a2 = new Author("Gautama Buddha");
		Author a3 = new Author("Albert Einstein");
		
		authorService.save(a1);
		authorService.save(a2);
		authorService.save(a3);
		
		return new AuthorData();
	}
	
}
