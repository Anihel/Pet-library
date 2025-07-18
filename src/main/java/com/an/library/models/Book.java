package com.an.library.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "book")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "year_published")
    private LocalDate published;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonBackReference("author-book")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    @JsonBackReference("genre-book")
    private Genre genre;

    public Book() {}

}
