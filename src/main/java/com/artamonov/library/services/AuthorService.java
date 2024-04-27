package com.artamonov.library.services;

import com.artamonov.library.dto.AuthorDto;
import com.artamonov.library.dto.mappers.AuthorMapper;
import com.artamonov.library.models.AuthorEntity;
import com.artamonov.library.models.BookEntity;
import com.artamonov.library.repositories.AuthorRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository repository;

    @Autowired
    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public List<AuthorDto> getAll() {
        List<AuthorEntity> entities = repository.findAll();
        List<AuthorDto> dtoList = new ArrayList<>();
        for (AuthorEntity entity : entities) {
            dtoList.add(AuthorMapper.INSTANCE.sourceToDto(entity));
        }
        return dtoList;
    }

    public AuthorDto getById(Long id) {
        AuthorEntity entity = repository.findById(id).orElse(new AuthorEntity());
        return AuthorMapper.INSTANCE.sourceToDto(entity);
    }

    public AuthorDto getAuthorByFullName(String name, String surname) {
        AuthorEntity entity = repository.findAuthorEntityByNameAndSurname(name, surname).orElse(new AuthorEntity());
        return AuthorMapper.INSTANCE.sourceToDto(entity);
    }

    public void addAuthor(AuthorDto dto) {
        AuthorEntity entity = AuthorMapper.INSTANCE.destinationToEntity(dto);
        repository.save(entity);
    }

    public void updateAuthor(Long id, AuthorDto dto) {
        AuthorEntity entity = repository.findById(id).orElse(new AuthorEntity());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        repository.save(entity);
    }

    public void deleteAuthor(Long id) {
        repository.deleteById(id);
    }
}
