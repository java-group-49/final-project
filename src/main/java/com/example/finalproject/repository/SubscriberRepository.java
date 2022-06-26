package com.example.finalproject.repository;

import com.example.finalproject.models.Subscriber;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Transactional
@Repository
public interface SubscriberRepository extends CrudRepository<Subscriber, Long> {
    Subscriber getSubscriber(String username);

    void deleteSubscriber(String username);

    @Modifying
    @Query(value = "update Subscriber s set s.username = ?1, s.email = ?2 where s.username = ?3")
    static void updateSubscriber(String username, String email, String oldName) {
    }
}