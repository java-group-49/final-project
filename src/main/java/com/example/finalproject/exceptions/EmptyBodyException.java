package com.example.finalproject.exceptions;

public class EmptyBodyException extends RuntimeException{
    public EmptyBodyException() {
        super("Body of email is empty!!!");
    }
}
