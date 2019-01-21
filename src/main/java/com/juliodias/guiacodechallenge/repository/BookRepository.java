package com.juliodias.guiacodechallenge.repository;

import com.juliodias.guiacodechallenge.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
