package com.juliodias.guiacodechallenge.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

public class BookClientService {

    @Value("${library.url}")
    private String libraryUrl;

    //TODO: Implement find books from site.
    public void connectLibrary() throws IOException {
    }

    private void listTitleOf(Document document) {
        document.select("h2")
                .stream()
                .map(Element::text)
                .forEach(System.out::println);
    }

    private void listLanguageOf(Document document) {
        document.select(".book-lang")
                .stream()
                .map(Element::text)
                .forEach(System.out::println);
    }

    private void listDescriptionOf(Document document) {
        document.select("p")
                .stream()
                .map(Element::text)
                .forEach(System.out::println);
    }
}
