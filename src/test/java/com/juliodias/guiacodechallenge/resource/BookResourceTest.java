package com.juliodias.guiacodechallenge.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juliodias.guiacodechallenge.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class BookResourceTest {

    private static final String BOOKS_API = "http://localhost:8080/books";
    private static final String BOOK_API = BOOKS_API;
    private static final String UNKNOWN_ID = "/100";
    private static final String KNOWN_ID = "/1";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createBookWithSuccess() throws Exception {
       mockMvc.perform(post(BOOKS_API)
               .contentType(APPLICATION_JSON)
               .content(objectMapper.writeValueAsString(createBook())))
               .andExpect(status().isCreated())
               .andExpect(content().json("{\"success\":true,\"description\":\"Book created with success.\"}"));
    }

    @Test
    public void getBookWithSuccess() throws Exception {
        mockMvc.perform(get(BOOK_API + KNOWN_ID))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 1,\"isbn\": \"Domain Driven Design\",\"title\": \"Tackling Complexity in the Heart of Software\",\"language\": \"English\",\"description\": \"ISBN-0933JI\" }"));
    }

    @Test
    public void handleBookNotFound() throws Exception {
        mockMvc.perform(get(BOOK_API + UNKNOWN_ID))
                .andExpect(status().isNotFound())
                .andExpect(content().json("{\"success\":false,\"description\":\"Book with id: 100 was not found.\"}"));
    }

    private Book createBook() {
        return Book.builder()
                .id(200L)
                .isbn("123-ISBN")
                .language("English")
                .title("Clean Code")
                .description("A Hand Book of Agile Software Craftsmanship")
                .build();
    }

}