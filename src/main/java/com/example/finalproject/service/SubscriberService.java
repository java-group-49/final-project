package com.example.finalproject.service;

import com.example.finalproject.exception.UserNotFoundException;
import com.example.finalproject.models.Subscriber;
import com.example.finalproject.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriberService {
    private final SubscriberRepository repository;

    @Autowired
    public SubscriberService(SubscriberRepository repository) {
        this.repository = repository;
    }

    public List<Subscriber> getAllSubscribers() {
        List<Subscriber> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        if(list.size() == 0)
            throw new UserNotFoundException("subscriber not found");
        return list;
    }

    public Subscriber getSubscriber(String username) {
        return repository.getSubscriberByUsername(username);
    }

    public void addSubscriber(Subscriber s) {
        repository.save(s);
    }

    public void update(Subscriber s, String username) {
        repository.updateSubscriber(s.getUsername(), s.getEmail(), username);
    }

    public void deleteSubscriber(String username) {
        repository.deleteSubscriberByUsername(username);
    }
}