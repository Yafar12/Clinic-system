package com.project.project.infrastructure.output.adapter;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.project.project.domain.model.Guest;
import com.project.project.domain.port.GuestFindByIdPort;
import com.project.project.infrastructure.output.persistence.GuestPersistenceMapper;
import com.project.project.infrastructure.output.persistence.RoomJpaRepository;

@Component
public class GuestFindByIdAdapter implements GuestFindByIdPort {

    private final RoomJpaRepository repository;
    private final GuestPersistenceMapper mapper;

    public GuestFindByIdAdapter(RoomJpaRepository repo, GuestPersistenceMapper mapper) {
        this.repository = repo;
        this.mapper = mapper;
    }

    @Override
    public Optional<Guest> findByDni(Integer dni) {
        return repository.findByDni(dni)
                .map(mapper::toDomain);
    }
}
