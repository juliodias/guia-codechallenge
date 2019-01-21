package com.juliodias.guiacodechallenge.exception;

import com.juliodias.guiacodechallenge.resource.response.BookResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.juliodias.guiacodechallenge.resource.response.BookResponse.*;
import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class BookExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<BookResponse> handleBookNotFoundException(Exception e) {
        String errorDescription = e.getMessage();

        return new ResponseEntity<>(errorResponse(errorDescription), NOT_FOUND);
    }

}
