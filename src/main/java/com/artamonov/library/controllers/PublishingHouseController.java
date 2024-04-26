package com.artamonov.library.controllers;

import com.artamonov.library.services.PublishingHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("publishing_houses/")
public class PublishingHouseController {

    private final PublishingHouseService service;

    @Autowired
    public PublishingHouseController(PublishingHouseService service) {
        this.service = service;
    }
}
