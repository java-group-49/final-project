package com.example.finalproject.controllers;

import com.example.finalproject.exception.UserNotFoundException;
import com.example.finalproject.models.ExceptionBody;
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

    @GetMapping("/subscribers")
    public ResponseEntity<Object> getSubscribers() {
        List<Subscriber> subscribers;
        try {
            subscribers = subscriberService.getAllSubscribers();
        } catch (UserNotFoundException ex) {
            return ResponseEntity.status(404).body(new ExceptionBody("No subscribers were found"));
        }
        return ResponseEntity.ok(subscribers);
    }

    @GetMapping("/subscriber")
    public ResponseEntity<Subscriber> getSubscribers(@PathVariable String username) {
        Subscriber s = subscriberService.getSubscriber(username);
        if (s == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(s);
    }

    @PostMapping("/addSubscriber")
    public ResponseEntity<Void> addSubscriber(@RequestBody Subscriber s) {
        subscriberService.addSubscriber(s);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update/{username}")
    public ResponseEntity<Void> updateSubscriber(@PathVariable String username, @RequestBody Subscriber s) {
        subscriberService.update(s, username);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity<Void> deleteSubscriber(@PathVariable String username) {
        subscriberService.deleteSubscriber(username);
        return ResponseEntity.status(202).build();
    }
}