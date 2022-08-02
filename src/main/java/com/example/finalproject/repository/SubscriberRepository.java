package com.example.finalproject.repository;

import com.example.finalproject.models.Subscriber;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface SubscriberRepository extends CrudRepository<Subscriber, Long> {
    @Query("SELECT s FROM Subscriber s " +
            "JOIN AuthorSubscriber ausb on s.id = ausb.subscriberId " +
            "JOIN Author au on au.id=ausb.authorId " +
            "WHERE au.nickname=?1")
    public List<Subscriber> getByAuthorNickname(String nickname);
}
