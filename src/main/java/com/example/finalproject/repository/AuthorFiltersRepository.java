package com.example.finalproject.repository;

import com.example.finalproject.models.Author;
import com.example.finalproject.models.AuthorSubscriber;
import com.example.finalproject.models.Post;
import com.example.finalproject.models.Subscriber;
import com.example.finalproject.service.AuthorService;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Repository
public class AuthorFiltersRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Author> getAuthorByParam(String subscriber, Byte rate){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Author> criteriaQuery = criteriaBuilder.createQuery(Author.class);

        Metamodel metamodel = em.getMetamodel();
        EntityType<Author> author_ = metamodel.entity(Author.class);
        EntityType<Subscriber> subscriber_ = metamodel.entity(Subscriber.class);
        Root<Author> authorRoot = criteriaQuery.from(Author.class);
        Root<Subscriber> subscriberRoot = criteriaQuery.from(Subscriber.class);

        Join<Author, Subscriber> authorSubscriberSetJoin = authorRoot.join("subscriberSet");

        List<Predicate> predicateList = new LinkedList<>();
        if(rate != null) {
            predicateList.add(criteriaBuilder.equal(authorRoot.get("rate"), rate));
        }
        if(subscriber != null){
            System.out.println("check");
            //predicateList.add(criteriaBuilder.equal(subscriberRoot.get("username"), subscriber));
        }

        Predicate finalPredicate = criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
        criteriaQuery.select(authorRoot).where(finalPredicate);

        return em.createQuery(criteriaQuery).getResultList();
        //return new ArrayList<>();
    }
}
