package com.example.finalproject.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private Byte rate;

    @Column
    private String nickname;

    @ManyToMany
    @JoinTable(
            name = "author_subscriber",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "subscriber_id")
    )
    Set<Subscriber> subscriberSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getRate() {
        return rate;
    }

    public void setRate(Byte rate) {
        this.rate = rate;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Set<Subscriber> getSubscriberSet() {
        return subscriberSet;
    }

    public void setSubscriberSet(Set<Subscriber> subscriberSet) {
        this.subscriberSet = subscriberSet;
    }
}
