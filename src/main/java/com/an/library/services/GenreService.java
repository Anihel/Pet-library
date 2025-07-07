package com.an.library.services;

import com.an.library.models.Genre;
import com.an.library.repositories.GenreRepository;
import org.springframework.stereotype.Service;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public void save(Genre genre) {
        genreRepository.save(genre);
    }

    public void delete(Long id) {
        genreRepository.deleteById(id);
    }

    public Genre findById(Long id) {
        return genreRepository.findById(id).orElse(null);
    }
}
