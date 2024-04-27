package com.artamonov.library.controllers;

import com.artamonov.library.dto.BookDto;
import com.artamonov.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping()
    public List<BookDto> findAll() {
        return service.getBooks();
    }

    @GetMapping("/{id}")
    public BookDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public void addBook(HttpServletResponse response, @RequestBody BookDto dto) throws IOException {
        service.addBook(dto);
        response.sendRedirect("/books");
    }

    @PatchMapping("/{id}")
    public void updateBook(HttpServletResponse response, @PathVariable Long id, @RequestBody BookDto dto) throws IOException {
        service.updateBook(id, dto);
        response.sendRedirect("/books");
    }

    @DeleteMapping("/{id}")
    public void deleteBook(HttpServletResponse response, @PathVariable Long id) throws IOException {
        service.deleteBook(id);
        response.sendRedirect("/books");
    }
}
