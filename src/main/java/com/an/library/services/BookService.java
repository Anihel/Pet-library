package com.an.library.services;

import com.an.library.repositories.AuthorRepository;

public class BookService {

    private final AuthorRepository authorRepository;

    public BookService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

}
