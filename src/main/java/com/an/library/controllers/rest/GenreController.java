package com.an.library.controllers.rest;

import com.an.library.models.Genre;
import com.an.library.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genre")
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping("/create")
    public ResponseEntity<Genre> addNewGenre(@RequestBody Genre genre) {
        genreService.save(genre);
        return ResponseEntity.status(HttpStatus.CREATED).body(genre);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Genre> deleteGenre(@PathVariable Long id) {
        genreService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
