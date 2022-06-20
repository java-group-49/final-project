package com.example.finalproject.repository;

import com.example.finalproject.models.AuthorSubscriber;
import org.springframework.data.repository.CrudRepository;

public interface SendingRepository extends CrudRepository<AuthorSubscriber, Long> {
}
