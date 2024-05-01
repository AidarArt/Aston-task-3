package com.artamonov.library.models;

import com.artamonov.library.dto.AuthorDto;
import com.artamonov.library.dto.mappers.AuthorMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class AuthorEntityTest {

    private AuthorEntity entity = new AuthorEntity();
    private final Set<BookEntity> books = new HashSet<>();

    @BeforeEach
    void setUp() {
        books.add(new BookEntity());
    }

    @Test
    void id() {
        entity.setId(1L);
        Assertions.assertEquals(1L, entity.getId());
    }

    @Test
    void books() {
        entity.setBooks(books);
        Assertions.assertEquals(books, entity.getBooks());
    }

    @Test
    void destinationToEntity() {
        AuthorDto dto = new AuthorDto();
        dto.setName("name");
        dto.setSurname("surname");
        entity = AuthorMapper.INSTANCE.destinationToEntity(dto);
        Assertions.assertEquals(dto.getName(), entity.getName());
        Assertions.assertEquals(dto.getSurname(), entity.getSurname());

        Assertions.assertNull(AuthorMapper.INSTANCE.destinationToEntity(null));
    }
}
