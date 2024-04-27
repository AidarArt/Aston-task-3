package com.artamonov.library.controllers;

import com.artamonov.library.dto.AuthorDto;
import com.artamonov.library.models.AuthorEntity;
import com.artamonov.library.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService service;

    @Autowired
    public AuthorController(AuthorService service) {
        this.service = service;
    }


    @GetMapping
    public List<AuthorDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AuthorDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public void addAuthor(HttpServletResponse response, @RequestBody AuthorDto dto) throws IOException {
        service.addAuthor(dto);
        response.sendRedirect("/authors");
    }

    @PatchMapping("/{id}")
    public void updateAuthor(HttpServletResponse response, @PathVariable Long id, @RequestBody AuthorDto dto) throws IOException {
        service.updateAuthor(id, dto);
        response.sendRedirect("/authors");
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(HttpServletResponse response, @PathVariable Long id) throws IOException {
        service.deleteAuthor(id);
        response.sendRedirect("/authors");
    }
}
