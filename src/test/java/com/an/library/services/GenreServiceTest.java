package com.an.library.services;

import com.an.library.models.Genre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class GenreServiceTest {

    private final GenreService genreService;

    @Autowired
    public GenreServiceTest(GenreService genreService) {
        this.genreService = genreService;
    }

    @Test
    void shouldSaveGenre() {
        System.out.println("USERNAME" + System.getenv("DB_LIBRARY_TEST_USERNAME"));
        Genre genre = new Genre();
        genre.setName("Genre Test 1");

        Genre saved = genreService.save(genre);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getName()).isEqualTo("Genre Test 1");
        genreService.delete(saved.getId());
    }
}
