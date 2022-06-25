package com.example.finalproject.repository;

import com.example.finalproject.models.Subscriber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface SubscriberRepository extends CrudRepository<Subscriber, Long> {
}
