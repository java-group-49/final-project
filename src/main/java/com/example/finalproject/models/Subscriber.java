package com.example.finalproject.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "subscriber")
public class Subscriber {
    @Id
    private Long id;
    private String username;
    private String email;
}
