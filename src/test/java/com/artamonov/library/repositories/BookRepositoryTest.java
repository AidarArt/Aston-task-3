package com.artamonov.library.repositories;

import com.artamonov.library.config.DatabaseConfig;
import com.artamonov.library.config.SpringConfig;
import com.artamonov.library.models.BookEntity;
import com.artamonov.library.models.PublishingHouseEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = SpringConfig.class)
@ContextConfiguration(classes = DatabaseConfig.class)
class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    void crudBook() {
        BookEntity entity = new BookEntity();
        entity.setName("name");
        entity.setPublishingYear(1111);
        entity.setPublishingHouse(new PublishingHouseEntity());
        entity.getPublishingHouse().setId(1L);

        Long id = repository.save(entity).getId();
        entity = repository.findById(id).orElse(new BookEntity());
        Assertions.assertEquals("name", entity.getName());
        Assertions.assertEquals(1111, entity.getPublishingYear());

        entity.setName("name1");
        id = repository.save(entity).getId();
        Assertions.assertEquals("name1", repository.findById(id).get().getName());

        repository.deleteById(id);
    }
}
