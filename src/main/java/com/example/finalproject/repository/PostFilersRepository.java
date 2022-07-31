package com.example.finalproject.repository;

import com.example.finalproject.exceptions.IncorrectValueException;
import com.example.finalproject.models.Author;
import com.example.finalproject.models.Post;
import com.example.finalproject.models.Tag;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Repository
public class PostFilersRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Post> getPostsByParam(String author, String tag, LocalDate startDate, LocalDate endDate) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery <Post> criteriaQuery = criteriaBuilder.createQuery(Post.class);

        Metamodel metamodel = em.getMetamodel();
        EntityType<Post> post_ = metamodel.entity(Post.class);
        Root <Post> postRoot = criteriaQuery.from(Post.class);

        postRoot.join(post_.getSingularAttribute("tag", Tag.class));
        postRoot.join(post_.getSingularAttribute("author", Author.class));

        List<Predicate> predicateList = new LinkedList<>();
        if(startDate != null) {
            predicateList.add(criteriaBuilder.greaterThanOrEqualTo(postRoot.get("publicationDate"), Date.valueOf(startDate)));

        }
        if(endDate != null) {
            predicateList.add(criteriaBuilder.lessThanOrEqualTo(postRoot.get("publicationDate"), Date.valueOf(endDate)));
        }
            if(author != null) {
                predicateList.add(criteriaBuilder.equal(postRoot.get("author").get("name"), author));
        }
        if(tag != null) {
            predicateList.add(criteriaBuilder.equal(postRoot.get("tag").get("name"), tag));
        }

        Predicate finalPredicate = criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
        criteriaQuery.select(postRoot).where(finalPredicate);

        return em.createQuery(criteriaQuery).getResultList();
    }
}
