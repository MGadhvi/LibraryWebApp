package com.sparta.mg.librarywebapp.controller;

import com.sparta.mg.librarywebapp.model.entities.Author;
import com.sparta.mg.librarywebapp.model.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AuthorController {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/author/{id}")
    public String getAuthor(Model model, @PathVariable Integer id) {
        model.addAttribute("author",
                authorRepository.findById(id).orElse(null));
        return "author";
    }

    @GetMapping("/authors")
    public String getAllAuthors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "authors";
    }

    @GetMapping("/author/edit/{id}")
    public String getAuthorToEdit(@PathVariable Integer id, Model model) {
        Author author = authorRepository.findById(id).orElse(null);
        model.addAttribute("authorToEdit", author);
        return "author-edit-form";
    }

    @PostMapping("/updateAuthor")
    public String updateAuthor(@ModelAttribute("authorToEdit")Author editedAuthor) {
        authorRepository.saveAndFlush(editedAuthor);
        return "edit-success";
    }
}
