package com.artamonov.library.dto;

public class BookDto {

    private String name;
    private int publishingYear;
    private Long publishingHouse;

    public Long getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(Long publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
