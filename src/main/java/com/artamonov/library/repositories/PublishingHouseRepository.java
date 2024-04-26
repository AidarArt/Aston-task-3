package com.artamonov.library.repositories;

import com.artamonov.library.models.PublishingHouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublishingHouseRepository extends JpaRepository<PublishingHouseEntity, Long> {
    Optional<PublishingHouseEntity> findPublishingHouseEntityByName(String name);
}
