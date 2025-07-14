package com.an.library.unit.services;


import com.an.library.DTO.BookRequestDTO;
import com.an.library.models.Author;
import com.an.library.models.Book;
import com.an.library.models.Genre;
import com.an.library.repositories.BookRepository;
import com.an.library.services.AuthorService;
import com.an.library.services.BookService;
import com.an.library.services.GenreService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;
    @Mock
    private AuthorService authorService;
    @Mock
    private GenreService genreService;
    @InjectMocks
    private BookService bookService;

    @Test
    void createBook() {
        Long authorId = 1L;
        Long genreId = 2L;
        LocalDate publishedDate = LocalDate.of(2020, 1, 1);
        String title = "test Book";

        BookRequestDTO requestDTO = BookRequestDTO.builder()
                .authorId(authorId)
                .genreId(genreId)
                .title(title)
                .publishDate(publishedDate)
                .build();

        Author author = new Author();
        author.setId(authorId);

        Genre genre = new Genre();
        genre.setId(genreId);

        Book savedBook = Book.builder()
                .id(10L)
                .title(title)
                .author(author)
                .genre(genre)
                .published(publishedDate)
                .build();

        when(authorService.findById(authorId)).thenReturn(author);
        when(genreService.findById(genreId)).thenReturn(genre);
        when(bookRepository.save(any(Book.class))).thenReturn(savedBook);

        Book result = bookService.create(requestDTO);

        assertThat(result).isEqualTo(savedBook);
        verify(authorService).findById(authorId);
        verify(genreService).findById(genreId);
        verify(bookRepository).save(argThat(b ->
                b.getTitle().equals(title) &&
                b.getAuthor().equals(author) &&
                b.getGenre().equals(genre) &&
                b.getPublished().equals(publishedDate)
        ));
    }
}
