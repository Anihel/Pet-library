package com.an.library.controllers.html;

import com.an.library.models.Book;
import com.an.library.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookPageController {

    private final BookService bookService;

    @GetMapping("/all")
    public String BooksView(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "book/books";
    }
}
