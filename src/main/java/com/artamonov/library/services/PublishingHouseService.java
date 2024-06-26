package com.artamonov.library.services;

import com.artamonov.library.dto.BookDto;
import com.artamonov.library.dto.PublishingHouseDto;
import com.artamonov.library.dto.mappers.BookMapper;
import com.artamonov.library.dto.mappers.PublishingHouseMapper;
import com.artamonov.library.models.BookEntity;
import com.artamonov.library.models.PublishingHouseEntity;
import com.artamonov.library.repositories.BookRepository;
import com.artamonov.library.repositories.PublishingHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PublishingHouseService {

    private final PublishingHouseRepository repository;
    private final BookRepository bookRepository;

    @Autowired
    public PublishingHouseService(PublishingHouseRepository repository, BookRepository bookRepository) {
        this.repository = repository;
        this.bookRepository = bookRepository;
    }

    public List<BookDto> getBooksByPublishingHouse(Long id) {
        List<BookEntity> entities = bookRepository.findBooksByPublishingHouseId(id);
        List<BookDto> dtoList = new ArrayList<>();
        for (BookEntity entity : entities) {
            dtoList.add(BookMapper.INSTANCE.sourceToDto(entity));
        }
        return dtoList;
    }


    public List<PublishingHouseDto> getPublishingHouses() {
        List<PublishingHouseEntity> entities = repository.findAll();
        List<PublishingHouseDto> dtoList = new ArrayList<>();
        for (PublishingHouseEntity entity : entities) {
            dtoList.add(PublishingHouseMapper.INSTANCE.sourceToDto(entity));
        }
        return dtoList;
    }

    public PublishingHouseDto getByName(String name) {
        PublishingHouseEntity entity = repository.findPublishingHouseEntityByName(name).orElse(new PublishingHouseEntity());
        return PublishingHouseMapper.INSTANCE.sourceToDto(entity);
    }

    public PublishingHouseDto getById(Long id) {
        PublishingHouseEntity entity = repository.findById(id).orElse(new PublishingHouseEntity());
        return PublishingHouseMapper.INSTANCE.sourceToDto(entity);
    }

    public void addPublishingHouse(PublishingHouseDto dto) {
        PublishingHouseEntity entity = PublishingHouseMapper.INSTANCE.destinationToEntity(dto);
        repository.save(entity);
    }

    public void updatePublishingHouse(Long id, PublishingHouseDto dto) {
        Optional<PublishingHouseEntity> entity = repository.findById(id);
        if (entity.isPresent()) {
            PublishingHouseEntity entity1 = entity.get();
            entity1.setName(dto.getName());
            repository.save(entity1);
        }
    }

    public void deletePublishingHouse(Long id) {
        repository.deleteById(id);
    }
}
