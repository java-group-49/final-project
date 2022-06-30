package com.example.finalproject.service;

import com.example.finalproject.exceptions.IncorrectValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EmailService {


    private final JavaMailSender emailSender;

    @Autowired
    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }


    public void sendSimpleMessage(String to, String text) {
        Pattern pattern = Pattern.compile("^\\w+([.\\w]+)*\\w@\\w((.\\w)*\\w+)*\\.\\w{2,3}$");
        Matcher matcher = pattern.matcher(to);
        if(!matcher.matches() || text.isEmpty()) {
            throw new IncorrectValueException("Incorrect value of recipient");
        }
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("accforgit49@gmail.com");
            message.setTo(to);
            message.setSubject("New posts in the last day");
            message.setText(text);
            emailSender.send(message);

    }
}
