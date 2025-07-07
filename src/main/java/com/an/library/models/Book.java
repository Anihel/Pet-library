package com.an.library.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "book")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "year_published")
    private LocalDateTime published;

    @Column(name = "genre")
    private String genre;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author owner;

}
