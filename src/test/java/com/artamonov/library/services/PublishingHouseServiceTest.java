package com.artamonov.library.services;

import com.artamonov.library.dto.PublishingHouseDto;
import com.artamonov.library.models.BookEntity;
import com.artamonov.library.models.PublishingHouseEntity;
import com.artamonov.library.repositories.BookRepository;
import com.artamonov.library.repositories.PublishingHouseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.Optional;

class PublishingHouseServiceTest {

    private final PublishingHouseRepository repository = Mockito.mock(PublishingHouseRepository.class);
    private final BookRepository bRepository = Mockito.mock(BookRepository.class);
    private final PublishingHouseService service = new PublishingHouseService(repository, bRepository);
    private PublishingHouseEntity entity;

    @BeforeEach
    void setUp() {
        entity = new PublishingHouseEntity();
        Mockito.when(repository.findAll()).thenReturn(Collections.singletonList(entity));
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(entity));
        Mockito.when(bRepository.findBooksByPublishingHouseId(1L)).thenReturn(Collections.singletonList(new BookEntity()));
    }

    @Test
    void getAll() {
        service.getPublishingHouses();
        Mockito.verify(repository, Mockito.times(1)).findAll();
    }

    @Test
    void getById() {
        service.getById(1L);
        Mockito.verify(repository, Mockito.times(1)).findById(1L);
    }

    @Test
    void getPublishingHouseBooks() {
        service.getBooksByPublishingHouse(1L);
        Mockito.verify(bRepository, Mockito.times(1)).findBooksByPublishingHouseId(1L);
    }

    @Test
    void getByName() {
        service.getByName("name");
        Mockito.verify(repository, Mockito.times(1)).findPublishingHouseEntityByName("name");
    }

    @Test
    void updatePH() {
        service.updatePublishingHouse(1L, new PublishingHouseDto());
        Mockito.verify(repository, Mockito.times(1)).findById(1L);
    }

    @Test
    void deletePH() {
        service.deletePublishingHouse(1L);
        Mockito.verify(repository, Mockito.times(1)).deleteById(1L);
    }
}
