package com.example.finalproject.service;

import com.example.finalproject.models.Author;
import com.example.finalproject.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService{
    private final   AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void add(Author author) {
        authorRepository.save(author);
    }

}