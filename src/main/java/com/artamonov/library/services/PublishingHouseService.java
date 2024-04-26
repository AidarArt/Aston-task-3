package com.artamonov.library.services;

import com.artamonov.library.repositories.PublishingHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishingHouseService {

    private final PublishingHouseRepository repository;

    @Autowired
    public PublishingHouseService(PublishingHouseRepository repository) {
        this.repository = repository;
    }
}
