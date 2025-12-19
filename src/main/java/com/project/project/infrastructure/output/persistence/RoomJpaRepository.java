package com.project.project.infrastructure.output.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomJpaRepository extends JpaRepository<GuestEntity, UUID> {
    boolean existsByDni(Integer dni);

    Optional<GuestEntity> findByDni(Integer dni);
}
