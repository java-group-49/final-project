package com.example.finalproject.service;

import com.example.finalproject.models.Subscriber;
import com.example.finalproject.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class SubscriberService {
    private final SubscriberRepository subscriberRepository;

    public SubscriberService(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }


    public void add(Subscriber subscriber){
        subscriberRepository.save(subscriber);
    }

    public List<Subscriber> getByAuthor(String nickname){
        if(nickname == null){
            List<Subscriber> list = new LinkedList<>();
            subscriberRepository.findAll().forEach(list::add);
            return list;
        }
        return subscriberRepository.getByAuthorNickname(nickname);
    }
}
