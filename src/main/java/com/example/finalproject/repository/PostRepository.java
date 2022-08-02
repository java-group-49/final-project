package com.example.finalproject.repository;

import com.example.finalproject.models.EmailMessageModel;
import com.example.finalproject.models.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
@Transactional
@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    @Query(value = "SELECT new com.example.finalproject.models.EmailMessageModel(sb.email, au.nickname, p.title, p.body)  " +
            "FROM Post p JOIN p.author au JOIN AuthorSubscriber ausb on au.id = ausb.authorId " +
            "JOIN Subscriber sb on sb.id = ausb.subscriberId " +
            "WHERE ?1 < p.publicationDate AND p.publicationDate < ?2")
    List<EmailMessageModel> getListOfDataForSending(Date from, Date to);


}
