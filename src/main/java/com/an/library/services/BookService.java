package com.an.library.services;

import com.an.library.DTO.BookRequestDTO;
import com.an.library.models.Author;
import com.an.library.models.Book;
import com.an.library.models.Genre;
import com.an.library.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final GenreService genreService;

    public BookService(BookRepository bookRepository, AuthorService authorService, GenreService genreService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.genreService = genreService;
    }

    public Book create(BookRequestDTO bookRequestDTO) {
        Genre genre = genreService.findById(bookRequestDTO.getGenreId());
        Author author = authorService.findById(bookRequestDTO.getAuthorId());
        Book book = Book.builder()
                .title(bookRequestDTO.getTitle())
                .author(author)
                .genre(genre)
                .published(bookRequestDTO.getPublishDate())
                .build();

        return bookRepository.save(book);
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

}
