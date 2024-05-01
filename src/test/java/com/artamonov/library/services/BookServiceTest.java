package com.artamonov.library.services;

import com.artamonov.library.dto.BookDto;
import com.artamonov.library.models.BookEntity;
import com.artamonov.library.models.PublishingHouseEntity;
import com.artamonov.library.repositories.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.Optional;

class BookServiceTest {

    private final BookRepository repository = Mockito.mock(BookRepository.class);
    private final BookService service = new BookService(repository);
    private BookEntity entity;

    @BeforeEach
    void setUp() {
        entity = new BookEntity();
        entity.setPublishingHouse(new PublishingHouseEntity());
        Mockito.when(repository.findAll()).thenReturn(Collections.singletonList(entity));
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(entity));
    }

    @Test
    void getAll() {
        service.getBooks();
        Mockito.verify(repository, Mockito.times(1)).findAll();
    }

    @Test
    void getById() {
        service.getById(1L);
        Mockito.verify(repository, Mockito.times(1)).findById(1L);
    }

    @Test
    void updateBook() {
        service.updateBook(1L, new BookDto());
        Mockito.verify(repository, Mockito.times(1)).findById(1L);
    }

    @Test
    void deleteBook() {
        service.deleteBook(1L);
        Mockito.verify(repository, Mockito.times(1)).deleteById(1L);
    }

}
