package com.an.library.unit.services;


import com.an.library.models.Genre;
import com.an.library.repositories.GenreRepository;
import com.an.library.services.GenreService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GenreServiceTest {

    @Test
    void createGenre() {
        GenreRepository genreRepository = mock(GenreRepository.class);
        GenreService genreService = new GenreService(genreRepository);

        Genre input = new Genre();
        input.setId(null);
        input.setName("GenreTest");

        Genre saved = new Genre();
        saved.setId(1L);
        saved.setName("GenreTest");

        when(genreRepository.save(input)).thenReturn(saved);

        Genre result = genreService.save(input);

        Assertions.assertThat(result.getId()).isEqualTo(1L);
        verify(genreRepository, times(1)).save(input);
    }
}
