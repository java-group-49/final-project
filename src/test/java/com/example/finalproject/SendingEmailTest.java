package com.example.finalproject;

import com.example.finalproject.models.EmailMessageModel;
import com.example.finalproject.repository.PostRepository;
import com.example.finalproject.schedulers.SendingEmail;
import com.example.finalproject.service.EmailService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.ExpectedCount.once;

@SpringBootTest
public class SendingEmailTest {

    @Mock
    private PostRepository postRepository;
    @Mock
    private EmailService emailService;
    @InjectMocks
    private SendingEmail sendingEmail;

    @Test
    public void testingOfEmail(){
        when(postRepository.getListOfDataForSending(any(Date.class), any(Date.class))).thenReturn(
                        List.of(new EmailMessageModel("test@gmail.com","testAuthor","testTitle","testBody")));
        sendingEmail.send();
        verify(emailService, times(1)).sendSimpleMessage("test@gmail.com",
                "---------------------------------\ntestTitle\nFrom:\ttestAuthor\n\ntestBody\n\n");
    }

    @Test
    public void testingWithEmptyList(){
        when(postRepository.getListOfDataForSending(any(Date.class), any(Date.class))).thenReturn(new ArrayList<>());
        sendingEmail.send();
        verify(emailService, times(0)).sendSimpleMessage(any(),any());
    }
}
