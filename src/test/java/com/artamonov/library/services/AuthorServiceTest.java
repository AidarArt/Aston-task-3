package com.artamonov.library.services;

import com.artamonov.library.dto.AuthorDto;
import com.artamonov.library.models.AuthorEntity;
import com.artamonov.library.repositories.AuthorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.Optional;

class AuthorServiceTest {
    private final AuthorRepository repository = Mockito.mock(AuthorRepository.class);
    private final AuthorService authorService = new AuthorService(repository);

    @BeforeEach
    void setUp() {
        Mockito.when(repository.findAll()).thenReturn(Collections.singletonList(new AuthorEntity()));
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(new AuthorEntity()));
        Mockito.when(repository.findAuthorEntityByNameAndSurname("name", "surname")).thenReturn(Optional.of(new AuthorEntity()));
    }

    @Test
    void getAll() {
        Assertions.assertEquals(1, authorService.getAll().size());
        Mockito.verify(repository, Mockito.times(1)).findAll();
    }

    @Test
    void getById() {
        authorService.getById(1L);
        Mockito.verify(repository, Mockito.times(1)).findById(1L);
    }

    @Test
    void getAuthorByFullName() {
        authorService.getAuthorByFullName("name", "surname");
        Mockito.verify(repository, Mockito.times(1)).findAuthorEntityByNameAndSurname("name", "surname");
    }
}
