package com.quoteservice.author.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quoteservice.author.model.Author;
import com.quoteservice.author.service.AuthorService;

@RestController
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@RequestMapping(value="/api/authorId", method = RequestMethod.GET)
	public Author getAuthorById(@RequestParam(value="id", defaultValue="1") Long id){
		Author author = authorService.findById(id);
		return author;
	}
	
	@RequestMapping(value="/api/authorName", method=RequestMethod.GET)
	public Author getAuthorIdByName(@RequestParam(value="name") String name) {
		Author author=authorService.findByName(name);
		if(author==null) {
			return authorService.findByName("Gautama Buddha");
		}else {
			return author;
		}
	}
	
	@RequestMapping(value="/api/saveAuthor", method = RequestMethod.POST)
	public long saveAuthor(@RequestBody Author author) {
		Author a=authorService.findByName(author.getName());
		if(a==null) {
			authorService.save(author);	
		}else{
			System.out.println("Author already existed");
		}
		
		return authorService.findByName(author.getName()).getId();
	}
}
