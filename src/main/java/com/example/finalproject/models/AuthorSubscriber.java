package com.example.finalproject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "author_subscriber")
public class AuthorSubscriber implements Serializable {
    @Id
    @Column(name = "author_id")
    private Long authorId;

    @Id
    @Column(name = "subscriber_id")
    private Long subscriberId;
}
