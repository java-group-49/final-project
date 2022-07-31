package com.example.finalproject.controllers;

import com.example.finalproject.exceptions.IncorrectValueException;
import com.example.finalproject.models.AuthorSubscriber;
import com.example.finalproject.service.AuthorSubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorSubscriberController {
    private final AuthorSubscriberService authorSubscriberService;

    @Autowired
    public AuthorSubscriberController(AuthorSubscriberService authorSubscriberService) {
        this.authorSubscriberService = authorSubscriberService;
    }

    @PostMapping("/subscribe")
    public ResponseEntity<String> addAuthorSubscriber(@RequestBody AuthorSubscriber authorSubscriber) {
        try {
            authorSubscriberService.add(authorSubscriber);
            return ResponseEntity.status(201).body("OK");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Некоректное значение");
        }
    }
}