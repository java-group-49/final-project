package com.example.finalproject.repository;

import com.example.finalproject.exceptions.IncorrectValueException;
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
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GetPostByParam {
    @PersistenceContext
    private EntityManager em;

    public List<Post> getPostsByParam(String author, String tag, LocalDate startDate, LocalDate endDate) {
        if(author.isEmpty() || tag.isEmpty())
            throw new IncorrectValueException("Incorrect value!!!");
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery <Post> criteriaQuery = criteriaBuilder.createQuery(Post.class);

        Metamodel metamodel = em.getMetamodel();
        EntityType<Post> post_ = metamodel.entity(Post.class);
        Root <Post> postRoot = criteriaQuery.from(Post.class);
        //Root<Author> authorRoot = criteriaQuery.from(Author.class);
        //Root<Tag> tagRoot = criteriaQuery.from(Tag.class);

        Join<Post, Tag> postTagJoin = postRoot.join(post_.getSingularAttribute("tag", Tag.class));
        Join<Post, Author> postAuthorJoin = postRoot.join(post_.getSingularAttribute("author", Author.class));

        Predicate startTime = criteriaBuilder.greaterThanOrEqualTo(postRoot.get("publicationDate"), Date.valueOf(startDate) );
        Predicate endTime = criteriaBuilder.lessThanOrEqualTo(postRoot.get("publicationDate"), Date.valueOf(endDate));
        Predicate authorName = criteriaBuilder.equal(postRoot.get("author").get("name"), author);
        Predicate tagName = criteriaBuilder.equal(postRoot.get("tag").get("name"), tag);
        Predicate finalPredicate = criteriaBuilder.and(startTime, endTime, authorName, tagName);

        criteriaQuery.where(finalPredicate);
        System.out.println("TESTERROR");
        return em.createQuery(criteriaQuery).getResultList();
        //return new ArrayList<>();
    }
}
