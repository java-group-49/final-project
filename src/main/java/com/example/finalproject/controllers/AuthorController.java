package com.example.finalproject.controllers;

import com.example.finalproject.models.Author;
import com.example.finalproject.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAuthorByParam(
            @RequestParam(required = false) String subscriber,
            @RequestParam(required = false) Byte rate
    ){
        System.out.println(subscriber + " " + rate);
        if(rate != null) {
            if (rate > 10 || rate < 0)
                return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(201).body(authorService.getByParam(subscriber, rate));
    }

}
