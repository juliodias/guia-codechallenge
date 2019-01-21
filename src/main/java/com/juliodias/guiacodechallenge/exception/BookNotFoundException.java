package com.juliodias.guiacodechallenge.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Long id) {
        super(String.format("Book with id: %d was not found.", id));
    }
}
