package com.artamonov.library.services;

import com.artamonov.library.dto.BookDto;
import com.artamonov.library.dto.mappers.BookMapper;
import com.artamonov.library.models.BookEntity;
import com.artamonov.library.models.PublishingHouseEntity;
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
            BookDto dto = BookMapper.INSTANCE.sourceToDto(entity);
            dto.setPublishingHouse(entity.getPublishingHouse().getId());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public BookDto getById(Long id) {
        BookEntity entity = repository.findById(id).orElse(new BookEntity());
        BookDto dto = BookMapper.INSTANCE.sourceToDto(entity);
        dto.setPublishingHouse(entity.getPublishingHouse().getId());
        return dto;
    }

    public void addBook(BookDto dto) {
        BookEntity entity = BookMapper.INSTANCE.destinationToEntity(dto);
        entity.setPublishingHouse(new PublishingHouseEntity());
        entity.getPublishingHouse().setId(dto.getPublishingHouse());
        repository.save(entity);
    }

    public void updateBook(Long id, BookDto dto) {
        BookEntity entity = repository.findById(id).orElse(new BookEntity());
        entity.setName(dto.getName());
        entity.setPublishingYear(dto.getPublishingYear());
        entity.setPublishingHouse(new PublishingHouseEntity());
        entity.getPublishingHouse().setId(dto.getPublishingHouse());
        repository.save(entity);
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
}
