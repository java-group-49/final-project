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
    private final SubscriberService service;

    @Autowired
    public SubscriberController(SubscriberService service) {
        this.service = service;
    }

    @GetMapping("/subscriber")
    public ResponseEntity<Object> getSubscribers() {
        List<Subscriber> subscribers;
        try {
            subscribers = service.getAllSubscriber();
        } catch (UserNotFoundException ex) {
            return ResponseEntity.status(404).body(new ExceptionBody("No subscribers were found"));
        }
        return ResponseEntity.ok(subscribers);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addSubscriber(@RequestBody Subscriber s) {
        service.addSubscriber(s);
        return ResponseEntity.status(201).build();
    }

 //   @PutMapping("/update/{name}")
//    public ResponseEntity<Void> updateSubscriber(@PathVariable String userName, @RequestBody subscriber s) {
//        service.update(s, userName);
//        return ResponseEntity.ok().build();
//    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<Void> deleteSubscriber(@PathVariable String userName) {
        service.deleteSubscriber(userName);
        return ResponseEntity.status(202).build();
    }

    @GetMapping("/student/{name}")
    public ResponseEntity<Subscriber> getSubscribers(@PathVariable String name) {
        Subscriber s = service.getSubscriber(name);

        if (s == null) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.ok(s);
    }
}