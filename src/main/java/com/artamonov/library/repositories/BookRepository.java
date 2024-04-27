package com.artamonov.library.repositories;

import com.artamonov.library.models.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    Optional<BookEntity> findBookEntityByName(String name);
    List<BookEntity> findBooksByPublishingHouseId(Long id);
}
