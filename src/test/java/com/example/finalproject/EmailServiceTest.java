package com.example.finalproject;

import com.example.finalproject.exceptions.IncorrectValueException;
import com.example.finalproject.service.EmailService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.ExpectedCount.once;

@SpringBootTest
public class EmailServiceTest {
    @Mock
    private JavaMailSender javaMailSender;
    @InjectMocks
    public EmailService emailService;

    @Test
    public void incorrectEmail(){
        assertThrows(IncorrectValueException.class,() -> emailService.sendSimpleMessage("asdf","text"));
    }

    @Test
    public void correctEmail(){
        assertThrows(IncorrectValueException.class, () -> emailService.sendSimpleMessage("test@gmail.com",""));
    }

    @Test
    public void emptyAllParam(){
        assertThrows(IncorrectValueException.class,() -> emailService.sendSimpleMessage("",""));
    }

    @Test
    public void correctAll(){
        assertThrows( IncorrectValueException.class ,() -> emailService.sendSimpleMessage("te....gg....st@gmail.com","test"));
    }

}
