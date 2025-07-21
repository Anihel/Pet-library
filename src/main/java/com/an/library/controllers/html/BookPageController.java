package com.an.library.controllers.html;

import com.an.library.models.Book;
import com.an.library.services.AuthorService;
import com.an.library.services.BookService;
import com.an.library.services.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookPageController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;

    @GetMapping("/all")
    public String BooksView(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "book/books";
    }

    @GetMapping("create")
    public String createBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("genres", genreService.findAll());
        return "admin/createBook";
    }

    @PostMapping("/create")
    public String addBook(@ModelAttribute Book book) {
        bookService.createBook(book);
        return "redirect:/book/create";
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
