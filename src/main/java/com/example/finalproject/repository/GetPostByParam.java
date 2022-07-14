package com.example.finalproject.repository;

import com.example.finalproject.models.Author;
import com.example.finalproject.models.Post;
import com.example.finalproject.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GetPostByParam {
    @PersistenceContext
    private EntityManager em;

    public List<Post> getPostsByParam(String author, String tag, LocalDate startDate, LocalDate endDate) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery <Post> criteriaQuery = criteriaBuilder.createQuery(Post.class);

        Metamodel metamodel = em.getMetamodel();
        EntityType<Post> post_ = metamodel.entity(Post.class);
        Root <Post> postRoot = criteriaQuery.from(Post.class);
        Root<Author> authorRoot = criteriaQuery.from(Author.class);
        Root<Tag> tagRoot = criteriaQuery.from(Tag.class);

        Join<Post, Tag> postTagJoin = postRoot.join(post_.getSingularAttribute("tag", Tag.class));
        Join<Post, Author> postAuthorJoin = postRoot.join(post_.getSingularAttribute("author", Author.class));

        List<Predicate> predicateList = new ArrayList<>();

        //adding elements of collection

        predicateList.add(criteriaBuilder.greaterThanOrEqualTo(postRoot.get("publicationDate"),startDate));
        predicateList.add(criteriaBuilder.lessThanOrEqualTo(postRoot.get("publicationDate"),endDate));
        predicateList.add(criteriaBuilder.equal(authorRoot.get("name"), author));
        predicateList.add(criteriaBuilder.equal(tagRoot.get("name"), tag));
        //Predicate predicate1 = criteriaBuilder.equal(root.get("authorId"), 1);


        criteriaQuery.where(predicateList.toArray(new Predicate[0]));
        return em.createQuery(criteriaQuery).getResultList();
    }
}
