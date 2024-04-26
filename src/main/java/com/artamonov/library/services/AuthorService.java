package com.artamonov.library.services;

import com.artamonov.library.dto.AuthorDto;
import com.artamonov.library.models.AuthorEntity;
import com.artamonov.library.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final AuthorRepository repository;

    @Autowired
    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public AuthorDto getAuthorByFullName(String name, String surname) {
        AuthorEntity entity = repository.findAuthorEntityByNameAndSurname(name, surname).orElse(new AuthorEntity());
        return null;
    }
}
