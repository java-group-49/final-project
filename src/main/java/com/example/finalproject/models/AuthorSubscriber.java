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
    @Column
    private Long author_id;

    @Id
    @Column
    private Long subscriber_id;
}
