package com.example.finalproject.models;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String body;
    @Column(name = "author_id")
    private Long authorId;
    @Column(name = "publication_date")
    private LocalDate publicationDate;
    @Column(name = "tag_id")
    private Long tagId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long author_id) {
        this.authorId = author_id;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publication_date) {
        this.publicationDate = publication_date;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tag_id) {
        this.tagId = tag_id;
    }
}
