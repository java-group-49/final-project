package com.example.finalproject.schedulers;

import com.example.finalproject.models.EmailMessageModel;
import com.example.finalproject.repository.PostRepository;
import com.example.finalproject.service.EmailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class SendingEmail {
    private EmailService emailService;
    private PostRepository postRepository;

    public SendingEmail(EmailService emailService, PostRepository postRepository) {
        this.emailService = emailService;
        this.postRepository = postRepository;
    }

    @Scheduled(cron = "0 0 3 * * *")
    public void send(){

        List<EmailMessageModel> listOfSending = postRepository.getListOfDataForSending(Date.valueOf(LocalDate.now().minusDays(1)),
                Date.valueOf(LocalDate.now()));

        Map<String, List<EmailMessageModel>> subscribersEmail = listOfSending.stream().
                collect(Collectors.groupingBy(EmailMessageModel::getEmailSubscriber));
        Set<String> emails = subscribersEmail.keySet();

        List <EmailMessageModel> buff;
        StringBuilder stringBuilder;

        for(String email:emails){
            stringBuilder = new StringBuilder();
            buff = subscribersEmail.get(email);
            for(EmailMessageModel emm : buff){
                stringBuilder.append(emm.toString());
            }
            emailService.sendSimpleMessage(email, stringBuilder.toString());
        }
    }
}
