package com.artamonov.library.controllers;

import com.artamonov.library.dto.BookDto;
import com.artamonov.library.dto.PublishingHouseDto;
import com.artamonov.library.services.PublishingHouseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

class PublishingHouseControllerTest {

    private final PublishingHouseService service = Mockito.mock(PublishingHouseService.class);
    private final PublishingHouseController controller = new PublishingHouseController(service);
    private final HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
    private PublishingHouseDto dto;

    @BeforeEach
    void setUp() {
        dto = new PublishingHouseDto();
        Mockito.when(service.getPublishingHouses()).thenReturn(Collections.singletonList(dto));
        Mockito.when(service.getById(1L)).thenReturn(dto);
        Mockito.when(service.getBooksByPublishingHouse(1L)).thenReturn(Collections.singletonList(new BookDto()));
    }

    @Test
    void getAll() {
        controller.getAll();
        Mockito.verify(service, Mockito.times(1)).getPublishingHouses();
    }

    @Test
    void getById() {
        controller.getById(1L);
        Mockito.verify(service, Mockito.times(1)).getById(1L);
    }

    @Test
    void getPHBooks() {
        controller.getPublishingHouseBooks(1L);
        Mockito.verify(service, Mockito.times(1)).getBooksByPublishingHouse(1L);
    }

    @Test
    void addPH() throws IOException {
        controller.addPublishingHouse(response, dto);
        Mockito.verify(service, Mockito.times(1)).addPublishingHouse(dto);
    }

    @Test
    void updatePH() throws IOException {
        controller.updatePublishingHouse(response, 1L, dto);
        Mockito.verify(service, Mockito.times(1)).updatePublishingHouse(1L, dto);
    }

    @Test
    void deletePH() throws IOException {
        controller.deletePublishingHouse(response, 1L);
        Mockito.verify(service, Mockito.times(1)).deletePublishingHouse(1L);
    }

}
