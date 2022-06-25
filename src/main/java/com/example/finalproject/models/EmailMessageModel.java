package com.example.finalproject.models;

public class EmailMessageModel {
    public EmailMessageModel(String emailSubscriber, String author, String postTitle, String bodyTitle) {
        this.emailSubscriber = emailSubscriber;
        this.author = author;
        this.titleOfPost = postTitle;
        this.bodyOfPost = bodyTitle;
    }

    private String emailSubscriber;

    private String author;

    private String titleOfPost;

    private String bodyOfPost;

    public String getEmailSubscriber() {
        return emailSubscriber;
    }

    public void setEmailSubscriber(String emailSubscriber) {
        this.emailSubscriber = emailSubscriber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitleOfPost() {
        return titleOfPost;
    }

    public void setTitleOfPost(String titleOfPost) {
        this.titleOfPost = titleOfPost;
    }

    public String getBodyOfPost() {
        return bodyOfPost;
    }

    public void setBodyOfPost(String bodyOfPost) {
        this.bodyOfPost = bodyOfPost;
    }

    @Override
    public String toString() {
        return "---------------------------------" +
                titleOfPost + "\nFrom:\t" +
                author + "\n\n" +
                bodyOfPost + "\n\n";
    }
}
