package com.artamonov.library.controllers;

import com.artamonov.library.dto.PublishingHouseDto;
import com.artamonov.library.services.PublishingHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/publishing_houses")
public class PublishingHouseController {

    private final PublishingHouseService service;

    @Autowired
    public PublishingHouseController(PublishingHouseService service) {
        this.service = service;
    }

    @GetMapping
    public List<PublishingHouseDto> getAll() {
        return service.getPublishingHouses();
    }

    @GetMapping("/{id}")
    public PublishingHouseDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public void addPublishingHouse(HttpServletResponse response, @RequestBody PublishingHouseDto dto) throws IOException {
        service.addPublishingHouse(dto);
        response.sendRedirect("/publishing_houses");
    }

    @PatchMapping("/{id}")
    @ResponseBody
    public void updatePublishingHouse(HttpServletResponse response, @PathVariable Long id, @RequestBody PublishingHouseDto dto) throws IOException {
        service.updatePublishingHouse(id, dto);
        response.sendRedirect("/publishing_houses");
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deletePublishingHouse(HttpServletResponse response, @PathVariable Long id) throws IOException {
        service.deletePublishingHouse(id);
        response.sendRedirect("/publishing_houses");
    }
}
