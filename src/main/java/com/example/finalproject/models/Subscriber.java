package com.example.finalproject.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "subscriber")
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String username;
    @Column
    private String email;
    @ManyToMany(mappedBy = "subscriberSet")
    Set<Author> authorSet;
}
