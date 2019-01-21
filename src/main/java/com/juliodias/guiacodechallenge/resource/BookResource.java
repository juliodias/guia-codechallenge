package com.juliodias.guiacodechallenge.resource;

import com.juliodias.guiacodechallenge.resource.response.BookResponse;
import com.juliodias.guiacodechallenge.domain.Book;
import com.juliodias.guiacodechallenge.service.BookService;
import com.juliodias.guiacodechallenge.util.LocationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static com.juliodias.guiacodechallenge.resource.response.BookResponse.successResponse;


@RestController
@RequestMapping("books")
@RequiredArgsConstructor
public class BookResource {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponse> create(@RequestBody Book book) {
        Book createdBook = bookService.create(book);

        URI uri = LocationUtil.locate(createdBook);

        return ResponseEntity.created(uri).body(successResponse());
    }

    @GetMapping("{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.findBook(id);
    }

    @GetMapping
    public List<Book> getBooks() {
       return bookService.findBooks();
    }
}
