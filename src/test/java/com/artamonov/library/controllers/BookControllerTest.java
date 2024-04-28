package com.artamonov.library.controllers;

import com.artamonov.library.dto.BookDto;
import com.artamonov.library.services.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

class BookControllerTest {

    private final BookService service = Mockito.mock(BookService.class);
    private final BookController controller = new BookController(service);
    private final HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
    private BookDto dto;

    @BeforeEach
    void setUp() {
        dto = new BookDto();
        Mockito.when(service.getBooks()).thenReturn(Collections.singletonList(dto));
        Mockito.when(service.getById(1L)).thenReturn(dto);
    }

    @Test
    void getAll() {
        controller.findAll();
        Mockito.verify(service, Mockito.times(1)).getBooks();
    }

    @Test
    void getById() {
        controller.getById(1L);
        Mockito.verify(service, Mockito.times(1)).getById(1L);
    }

    @Test
    void addBook() throws IOException {
        controller.addBook(response, dto);
        Mockito.verify(service, Mockito.times(1)).addBook(dto);
    }

    @Test
    void updateBook() throws IOException {
        controller.updateBook(response, 1L, dto);
        Mockito.verify(service, Mockito.times(1)).updateBook(1L, dto);
    }

    @Test
    void deleteBook() throws IOException {
        controller.deleteBook(response, 1L);
        Mockito.verify(service, Mockito.times(1)).deleteBook(1L);
    }
}
