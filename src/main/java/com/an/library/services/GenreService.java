package com.an.library.services;

import com.an.library.models.Genre;
import com.an.library.repositories.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }

    public void delete(Long id) {
        genreRepository.deleteById(id);
    }

    public Genre findById(Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    public List<Genre> findAll() {
        return genreRepository.findAll();
    }
}
