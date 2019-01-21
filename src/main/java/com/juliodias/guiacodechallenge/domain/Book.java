package com.juliodias.guiacodechallenge.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import static javax.persistence.GenerationType.*;

@Data
@Builder
@Entity
@Table(name = "books")
@NoArgsConstructor @AllArgsConstructor
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "title")
    private String title;

    @Column(name = "language")
    private String language;

    @Column(name = "description")
    private String description;
}
