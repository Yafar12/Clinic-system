package com.project.project.infrastructure.output.adapter;

import org.springframework.stereotype.Component;

import com.project.project.domain.model.Guest;
import com.project.project.domain.port.GuestCreatorPort;
import com.project.project.infrastructure.output.persistence.GuestEntity;
import com.project.project.infrastructure.output.persistence.GuestPersistenceMapper;
import com.project.project.infrastructure.output.persistence.RoomJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GuestCreatorAdapter implements GuestCreatorPort {

    private final RoomJpaRepository repository;
    private final GuestPersistenceMapper mapper;

    @Override
    public Guest perform(Guest guest) {

        String photoPath = null;

        GuestEntity entity = mapper.toEntity(guest);
        entity.setPhotoPath(photoPath);

        GuestEntity savedEntity = repository.save(entity);

        return mapper.toDomain(savedEntity);
    }

    @Override
    public boolean existsByDni(Integer dni) {
        return repository.existsByDni(dni);
    }
}