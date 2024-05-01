package com.artamonov.library.models;

import com.artamonov.library.dto.PublishingHouseDto;
import com.artamonov.library.dto.mappers.PublishingHouseMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PublishingHouseEntityTest {
    @Test
    void books() {
        PublishingHouseEntity entity = new PublishingHouseEntity();
        List<BookEntity> bookEntities = new ArrayList<>();
        entity.setBooks(bookEntities);
        Assertions.assertEquals(bookEntities, entity.getBooks());
    }

    @Test
    void destinationToEntity() {
        PublishingHouseDto dto = new PublishingHouseDto();
        dto.setName("name");
        PublishingHouseEntity entity = PublishingHouseMapper.INSTANCE.destinationToEntity(dto);

        Assertions.assertEquals(dto.getName(), entity.getName());
        Assertions.assertEquals(null, PublishingHouseMapper.INSTANCE.destinationToEntity(null));
    }
}
