package com.artamonov.library.repositories;

import com.artamonov.library.models.AuthorEntity;
import com.artamonov.library.models.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

    Optional<AuthorEntity> findAuthorEntityByNameAndSurname(String name, String surname);
}
