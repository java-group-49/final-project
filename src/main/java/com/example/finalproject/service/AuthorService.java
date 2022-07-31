package com.example.finalproject.service;

import com.example.finalproject.models.Author;
import com.example.finalproject.repository.AuthorFiltersRepository;
import com.example.finalproject.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService{
    private final   AuthorRepository authorRepository;
    private final AuthorFiltersRepository authorFiltersRepository;
    @Autowired
    public AuthorService(AuthorRepository authorRepository, AuthorFiltersRepository authorFiltersRepository) {
        this.authorRepository = authorRepository;
        this.authorFiltersRepository = authorFiltersRepository;
    }

    public void add(Author author) {
        authorRepository.save(author);
    }

    public List<Author> getByParam(String subscriber, Byte rate){
        System.out.println(rate + " " + subscriber);
//        //return authorFiltersRepository.getAuthorByParam(subscriber, rate);
//        if(rate != null && subscriber != null)
//            return authorRepository.authorAllParam(rate, subscriber);
//        else if(rate != null && subscriber == null)
//            return authorRepository.getAuthorsByRate(rate);
//        else if(rate == null && subscriber != null)
//            return authorRepository.authorSubscriberNameFilter(subscriber);
//        else {
//            List<Author> authorList = new ArrayList<>();
//            authorRepository.findAll().forEach(authorList::add);
//            return authorList;
//        }
        return authorFiltersRepository.getAuthorByParam(subscriber, rate);
    }
}
