package com.example.finalproject.repository;

import com.example.finalproject.models.Subscriber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Transactional
@Repository
public interface SubscriberRepository extends CrudRepository<Subscriber, Long> {
Subscriber getSubscriberByName(String name);

    void deleteSubscriberByName(String name);
//    @Modifying
 //   @Query(value = "update subscriber s set s.username = ?1, s.email = ?2 where s.name = ?3")
//    void updateSubscriber(String userName, String email, String oldName);

}
