package com.juliodias.guiacodechallenge.resource.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BookResponse {

    private boolean success;
    private String description;

    public static BookResponse successResponse() {
        return builder()
                .success(true)
                .description("Book created with success.")
                .build();
    }

    public static BookResponse errorResponse(String description) {
        return builder()
                .success(false)
                .description(description)
                .build();
    }
}
