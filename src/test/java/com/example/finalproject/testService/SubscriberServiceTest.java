package com.example.finalproject.testService;

import com.example.finalproject.exception.UserNotFoundException;
import com.example.finalproject.models.Subscriber;
import com.example.finalproject.repository.SubscriberRepository;
import com.example.finalproject.service.SubscriberService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;

public class SubscriberServiceTest {
    @Mock
    private SubscriberRepository subscriberRepository;
    @InjectMocks
    private SubscriberService subscriberService;

//    @Test
//    public void subscriberNotFoundTest() {
//        when(subscriberRepository.findAll()).thenReturn(new ArrayList<>());
//        assertThrows(UserNotFoundException.class, () -> subscriberService.getAllSubscribers(), "No subscribers were found");
//    }
//
//    @Test
//    public void subscribersWereFoundTest() {
//        Subscriber subscriber = new Subscriber();
//        when(subscriberRepository.findAll()).thenReturn(List.of(subscriber));
//        List<Subscriber> subscribers = subscriberService.getAllSubscribers();
//        assertEquals(1, subscribers.size());
//        verify(subscriberRepository, only()).findAll();
//    }
}