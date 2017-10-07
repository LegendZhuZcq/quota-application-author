package com.quoteservice.author.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.quoteservice.author.model.Author;

@Service
public interface AuthorService extends CrudRepository<Author, Long> {

    Author findByName(String name);
    Author findById(Long id);

}