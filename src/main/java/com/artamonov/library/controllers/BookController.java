package com.artamonov.library.controllers;

import com.artamonov.library.dto.BookDto;
import com.artamonov.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping
    public String addBook() {

        return "Book added successfully!";
    }
}
