package com.artamonov.library.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "publishing_year")
    private int publishingYear;

    @ManyToMany(mappedBy = "books")
    private Set<AuthorEntity> authors;

    @ManyToOne
    @JoinColumn(name = "publishing_house_id", nullable = false)
    private PublishingHouseEntity publishingHouse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public Set<AuthorEntity> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorEntity> authors) {
        this.authors = authors;
    }

    public PublishingHouseEntity getEntity() {
        return publishingHouse;
    }

    public void setEntity(PublishingHouseEntity publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public PublishingHouseEntity getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(PublishingHouseEntity publishingHouse) {
        this.publishingHouse = publishingHouse;
    }
}
