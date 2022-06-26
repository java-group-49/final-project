package com.example.finalproject.service;

import com.example.finalproject.models.Subscriber;
import com.example.finalproject.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriberService {
    private final SubscriberRepository repository;
    private final JavaMailSender javaMailSender;
    @Autowired
    public SubscriberService(SubscriberRepository repository, JavaMailSender javaMailSender) {
        this.repository = repository;
        this.javaMailSender = javaMailSender;
    }

    public List<Subscriber> getAllSubscribers() {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("accforgit49@gmail.com");
        message.setTo("ya10@ukr.net");
        message.setSubject("Test subject");
        message.setText("Test text");
        javaMailSender.send(message);

        return new ArrayList<>();
    }

    public Subscriber getSubscriber(String username) {
        return repository.getSubscriber(username);
    }
    public void addSubscriber(Subscriber s) {
        repository.save(s);
    }

    public void update (Subscriber s, String username) {
        repository.updateSubscriber(s.getUsername(), s.getEmail(), username);
    }

    public void deleteSubscriber(String username) {
        repository.deleteSubscriber(username);
    }
}