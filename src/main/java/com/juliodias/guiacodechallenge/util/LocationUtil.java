package com.juliodias.guiacodechallenge.util;

import java.net.URI;
import com.juliodias.guiacodechallenge.domain.Book;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.*;

public class LocationUtil {

    public static URI locate(Book book) {
        return fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(book.getId())
                .toUri();
    }
}
