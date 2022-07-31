package com.example.finalproject.repository;

import com.example.finalproject.models.Author;
import com.example.finalproject.models.Subscriber;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
@Query("SELECT a FROM Author a " +
        "JOIN AuthorSubscriber ausb on a.id = ausb.authorId " +
        "JOIN Subscriber s on ausb.subscriberId = s.id " +
        "WHERE a.rate = ?1 AND s.username = ?2")
public   List<Author> authorAllParam(byte rate, String subscriber);

public List<Author> getAuthorsByRate(byte rate);

    @Query("SELECT a FROM Author a " +
            "JOIN AuthorSubscriber ausb on a.id = ausb.authorId " +
            "JOIN Subscriber s on ausb.subscriberId = s.id " +
            "WHERE s.username = ?1")
    public   List<Author> authorSubscriberNameFilter(String subscriber);
}
