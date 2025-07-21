package com.an.library.controllers.html;

import com.an.library.models.Author;
import com.an.library.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller()
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorPageController {

    private final AuthorService authorService;

    @GetMapping("/create")
    public String AuthorPage(Model model) {
        model.addAttribute("author", new Author());
        return "admin/createAuthor";
    }

    @PostMapping("/create")
    public String addNewAuthor(@ModelAttribute Author author) {
        authorService.save(author);
        return "redirect:/author/create";
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable Long id) {
        authorService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
