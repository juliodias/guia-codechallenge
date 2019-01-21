package com.juliodias.guiacodechallenge.service;

import com.juliodias.guiacodechallenge.domain.Book;
import com.juliodias.guiacodechallenge.exception.BookNotFoundException;
import com.juliodias.guiacodechallenge.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book create(Book book) {
       return bookRepository.save(book);
    }

    public Book findBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return book.get();
        }
        throw new BookNotFoundException(id);
    }

    public List<Book> findBooks() {
        return bookRepository.findAll();
    }
}
