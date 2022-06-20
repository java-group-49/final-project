package com.example.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailService {


    private final JavaMailSender emailSender;

    @Autowired
    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Scheduled(cron = "0 0 12 * * *")
    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("accforgit49@gmail.com");
        message.setTo("dzinoveev@gmail.com");
        message.setSubject("Сообщение ждя футуре прогера");
        message.setText("Поздравляю, ты таки идийот, но не полный");
        emailSender.send(message);
    }
}
