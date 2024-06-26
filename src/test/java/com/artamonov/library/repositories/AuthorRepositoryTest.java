package com.artamonov.library.repositories;

import com.artamonov.library.config.DatabaseConfig;
import com.artamonov.library.config.SpringConfig;
import com.artamonov.library.models.AuthorEntity;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

@SpringJUnitConfig(classes = SpringConfig.class)
@ContextConfiguration(classes = DatabaseConfig.class)
@Testcontainers
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository repository;

    @Container
    private static final PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:15")
            .withDatabaseName("test")
            .withPassword("test")
            .withUsername("test")
            .withInitScript("0001-schema.sql");

    @DynamicPropertySource
    static void registerPgProperties(DynamicPropertyRegistry registry) {
        registry.add("database.url", container::getJdbcUrl);
        registry.add("database.username", container::getUsername);
        registry.add("database.password", container::getPassword);
    }

    @BeforeAll
    static void start() {
        container.start();
    }

    @AfterAll
    static void stop() {
        container.stop();
    }

    @Test
    void findAll() {
        Assertions.assertFalse(repository.findAll().isEmpty());
    }

    @Test
    void findById() {
        AuthorEntity entity = repository.findById(1L).orElse(new AuthorEntity());
        Assertions.assertEquals("author1", entity.getName());
        Assertions.assertEquals("author1", entity.getSurname());
    }

    @Test
    void addAuthor() {
        AuthorEntity entity = new AuthorEntity();
        entity.setName("test1");
        entity.setSurname("test1");
        repository.save(entity);

        AuthorEntity entity1 = repository.findById(4L).orElse(new AuthorEntity());
        Assertions.assertEquals(entity1.getName(), entity.getName());
        Assertions.assertEquals(4, repository.findAll().size());
    }
}
