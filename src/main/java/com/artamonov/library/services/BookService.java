package com.artamonov.library.services;

import com.artamonov.library.dto.BookDto;
import com.artamonov.library.dto.mappers.BookMapper;
import com.artamonov.library.models.BookEntity;
import com.artamonov.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<BookDto> getBooks() {
        List<BookEntity> entities = repository.findAll();
        List<BookDto> dtoList = new ArrayList<>();
        for (BookEntity entity : entities) {
            dtoList.add(BookMapper.INSTANCE.sourceToDto(entity));
        }
        return dtoList;
    }

    public void addBook(BookDto dto) {
        BookEntity entity = BookMapper.INSTANCE.destinationToEntity(dto);
        repository.save(entity);
    }
}
