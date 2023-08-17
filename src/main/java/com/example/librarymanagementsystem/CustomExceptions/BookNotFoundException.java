package com.example.librarymanagementsystem.CustomExceptions;


public class BookNotFoundException extends Exception{

    public BookNotFoundException(String message) {
        super(message);
    }
}
