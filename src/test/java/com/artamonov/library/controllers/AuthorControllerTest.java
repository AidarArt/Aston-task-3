package com.artamonov.library.controllers;

import com.artamonov.library.dto.AuthorDto;
import com.artamonov.library.services.AuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

class AuthorControllerTest {

    private final AuthorService service = Mockito.mock(AuthorService.class);
    private final AuthorController controller = new AuthorController(service);
    private final HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
    private AuthorDto dto;

    @BeforeEach
    void setUp() {
        dto = new AuthorDto();
        Mockito.when(service.getAll()).thenReturn(Collections.singletonList(new AuthorDto()));
        Mockito.when(service.getById(1L)).thenReturn(new AuthorDto());
    }

    @Test
    void getAll() {
        controller.getAll();
        Mockito.verify(service, Mockito.times(1)).getAll();
    }

    @Test
    void getById() {
        controller.getById(1L);
        Mockito.verify(service, Mockito.times(1)).getById(1L);
    }

    @Test
    void addAuthor() throws IOException {
        controller.addAuthor(response,dto);
        Mockito.verify(service, Mockito.times(1)).addAuthor(dto);
    }

    @Test
    void updateAuthor() throws IOException {
        controller.updateAuthor(response, 1L, dto);
        Mockito.verify(service, Mockito.times(1)).updateAuthor(1L, dto);
    }

    @Test
    void deleteAuthor() throws IOException {
        controller.deleteAuthor(response, 1L);
        Mockito.verify(service, Mockito.times(1)).deleteAuthor(1L);
    }
}
