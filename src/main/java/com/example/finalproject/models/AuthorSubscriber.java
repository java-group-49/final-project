package com.example.finalproject.models;

import com.example.finalproject.keys.AuthorSubscriberKey;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "author_subscriber")
@IdClass(AuthorSubscriberKey.class)
public class AuthorSubscriber implements Serializable {
    @Id
    @Column(name = "author_id")
    private Long authorId;

    @Id
    @Column(name = "subscriber_id")
    private Long subscriberId;

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Long subscriberId) {
        this.subscriberId = subscriberId;
    }
}
