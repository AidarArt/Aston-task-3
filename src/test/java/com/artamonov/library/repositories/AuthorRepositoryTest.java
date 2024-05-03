package com.artamonov.library.repositories;

import com.artamonov.library.config.DatabaseConfig;
import com.artamonov.library.config.SpringConfig;
import com.artamonov.library.models.AuthorEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(classes = SpringConfig.class)
@ContextConfiguration(classes = DatabaseConfig.class)
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository repository;

    @Test
    void crudAuthor() {
        AuthorEntity entity = new AuthorEntity();
        entity.setName("name");
        entity.setSurname("surname");
        Long id = repository.save(entity).getId();

        entity = repository.findById(id).orElse(new AuthorEntity());
        Assertions.assertEquals("name",entity.getName());
        Assertions.assertEquals("surname", entity.getSurname());

        entity.setName("name1");
        id = repository.save(entity).getId();
        Assertions.assertEquals("name1", repository.findById(id).get().getName());

        repository.deleteById(id);
    }
}
