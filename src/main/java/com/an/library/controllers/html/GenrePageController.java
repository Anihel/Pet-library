package com.an.library.controllers.html;

import com.an.library.models.Genre;
import com.an.library.services.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/genre")
public class GenrePageController {

    private final GenreService genreService;

    @GetMapping("/create")
    public String createPage(Model model) {
        model.addAttribute("genre", new Genre());
        return "admin/createGenre";
    }

    @PostMapping("/create")
    public String addNewGenre(@ModelAttribute Genre genre) {
        genreService.save(genre);
        return "redirect:/genre/create";
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Genre> deleteGenre(@PathVariable Long id) {
        genreService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
