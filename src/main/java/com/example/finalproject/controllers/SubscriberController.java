package com.example.finalproject.controllers;

import com.example.finalproject.models.Subscriber;
import com.example.finalproject.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubscriberController {
    private final SubscriberService subscriberService;

    @Autowired
    public SubscriberController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @PostMapping("/subscriber")
    public ResponseEntity<Void> add(@RequestBody Subscriber subscriber){
        subscriberService.add(subscriber);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/subscribers")
    public ResponseEntity<List<Subscriber>> getByAuthorNickname(@RequestParam(required = false) String author){
        System.out.println(author);
        return ResponseEntity.ok().body(subscriberService.getByAuthor(author));
    }

}
