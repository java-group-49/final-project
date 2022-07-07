package com.example.finalproject.service;

import com.example.finalproject.models.AuthorSubscriber;
import com.example.finalproject.repository.AuthorSubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorSubscriberService {
    private final AuthorSubscriberRepository authorSubscriberRepository;

    @Autowired
    public AuthorSubscriberService(AuthorSubscriberRepository authorSubscriberRepository) {
        this.authorSubscriberRepository = authorSubscriberRepository;
    }
    public void add(AuthorSubscriber authorSubscriber){authorSubscriberRepository.save(authorSubscriber);}
}
