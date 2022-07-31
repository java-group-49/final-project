package com.example.finalproject.keys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


public class AuthorSubscriberKey implements Serializable {
    private Long authorId;
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
