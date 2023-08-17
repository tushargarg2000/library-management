package com.example.librarymanagementsystem.CustomExceptions;


public class BookNotAvailableException extends Exception {

    public BookNotAvailableException(String message) {
        super(message);
    }
}
