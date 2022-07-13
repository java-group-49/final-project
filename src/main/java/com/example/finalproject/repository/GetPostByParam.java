package com.example.finalproject.repository;

import com.example.finalproject.models.Post;
import com.example.finalproject.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.List;

@Repository
public class GetPostByParam {
    @PersistenceContext
    private EntityManager em;

    public List<Post> getPostsByParam(String author, String tag, LocalDate startDate, LocalDate endDate) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery <Post> criteriaQuery = criteriaBuilder.createQuery(Post.class);
        Root <Post> root = criteriaQuery.from(Post.class);
        Join<Post, Tag> postTagJoin = root.join();

        Predicate predicate1 = criteriaBuilder.equal(root.get("authorId"), 1);
        criteriaQuery.where(predicate1);
        return em.createQuery(criteriaQuery).getResultList();
    }
}
