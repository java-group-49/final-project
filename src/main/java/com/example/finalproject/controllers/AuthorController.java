package com.example.finalproject.controllers;

import com.example.finalproject.models.Author;
import com.example.finalproject.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/author")
    public ResponseEntity<Void> addAuthor(@RequestBody Author author){
        authorService.add(author);
        return ResponseEntity.status(201).build();
    }

}
