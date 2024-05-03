package com.artamonov.library.repositories;

import com.artamonov.library.config.DatabaseConfig;
import com.artamonov.library.config.SpringConfig;
import com.artamonov.library.models.PublishingHouseEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = SpringConfig.class)
@ContextConfiguration(classes = DatabaseConfig.class)
class PublishingHouseRepositoryTest {

    @Autowired
    private PublishingHouseRepository repository;

    @Test
    void crudPH() {
        PublishingHouseEntity entity = new PublishingHouseEntity();
        entity.setName("name");
        Long id = repository.save(entity).getId();
        entity = repository.findById(id).orElse(new PublishingHouseEntity());
        Assertions.assertEquals("name", entity.getName());

        entity.setName("name1");
        repository.save(entity);
        entity = repository.findById(id).orElse(new PublishingHouseEntity());
        Assertions.assertEquals("name1", entity.getName());

        repository.deleteById(id);
    }
}
