package com.an.library.controllers;

import com.an.library.DTO.BookRequestDTO;
import com.an.library.models.Book;
import com.an.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BookService bookService;

    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    public ResponseEntity<Book> addBook(@RequestBody BookRequestDTO bookRequestDTO) {
        Book book = bookService.create(bookRequestDTO);
        return ResponseEntity.ok(book);
    }
}
