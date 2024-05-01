package com.artamonov.library.models;

import com.artamonov.library.dto.BookDto;
import com.artamonov.library.dto.mappers.BookMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class BookEntityTest {

    private BookEntity entity = new BookEntity();

    @Test
    void id() {
        entity.setId(1L);
        Assertions.assertEquals(1L, entity.getId());
    }

    @Test
    void ph() {
        PublishingHouseEntity publishingHouse = new PublishingHouseEntity();
        entity.setEntity(publishingHouse);
        Assertions.assertEquals(publishingHouse, entity.getEntity());
    }

    @Test
    void authors() {
        Set<AuthorEntity> entities = new HashSet<>();
        entity.setAuthors(entities);
        Assertions.assertEquals(entities, entity.getAuthors());
    }

    @Test
    void destinationToEntity() {
        BookDto dto = new BookDto();
        dto.setName("name");
        dto.setPublishingYear(1111);

        entity = BookMapper.INSTANCE.destinationToEntity(dto);

        Assertions.assertEquals("name", entity.getName());
        Assertions.assertEquals(1111, entity.getPublishingYear());

        Assertions.assertNull(BookMapper.INSTANCE.destinationToEntity(null));
    }
}
