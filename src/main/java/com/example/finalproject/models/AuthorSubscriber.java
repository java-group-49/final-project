package com.example.finalproject.models;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "author_subscriber")
public class AuthorSubscriber {
    @Column
    private Long author_id;

    @Column
    private Long subscriber_id;
}
