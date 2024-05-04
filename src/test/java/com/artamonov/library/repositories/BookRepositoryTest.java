package com.artamonov.library.repositories;

import com.artamonov.library.config.DatabaseConfig;
import com.artamonov.library.config.SpringConfig;
import com.artamonov.library.models.BookEntity;
import com.artamonov.library.models.PublishingHouseEntity;
import org.junit.jupiter.api.*;
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
class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

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
        Assertions.assertEquals("book2", repository.findById(2L).get().getName());
    }

    @Test
    void addBook() {
        BookEntity entity = new BookEntity();
        entity.setName("name");
        entity.setPublishingYear(1111);
        entity.setPublishingHouse(new PublishingHouseEntity());
        entity.getPublishingHouse().setId(1L);
        repository.save(entity);
        List<BookEntity> entities = repository.findAll();
        Assertions.assertEquals(4, entities.size());
    }
}
