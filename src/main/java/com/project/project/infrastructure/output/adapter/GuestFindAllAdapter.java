package com.project.project.infrastructure.output.adapter;

import java.util.List;

import org.springframework.stereotype.Component;

import com.project.project.domain.model.Guest;
import com.project.project.domain.port.GuestFindAllPort;
import com.project.project.infrastructure.output.persistence.GuestEntity;
import com.project.project.infrastructure.output.persistence.GuestPersistenceMapper;
import com.project.project.infrastructure.output.persistence.RoomJpaRepository;

@Component
public class GuestFindAllAdapter implements GuestFindAllPort {

    private final RoomJpaRepository repository;
    private final GuestPersistenceMapper mapper;

    public GuestFindAllAdapter(RoomJpaRepository repo, GuestPersistenceMapper mapper) {
        this.repository = repo;
        this.mapper = mapper;
    }

    @Override
    public List<Guest> perform() {

        List<GuestEntity> entities = repository.findAll();

        return entities.stream()
                .map(mapper::toDomain)
                .toList();
    }
}
