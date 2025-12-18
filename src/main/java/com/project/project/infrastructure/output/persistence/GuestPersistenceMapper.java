package com.project.project.infrastructure.output.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.project.project.domain.model.Guest;

@Mapper(componentModel = "spring")
public interface GuestPersistenceMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "photoPath", ignore = true)
    GuestEntity toEntity(Guest guest);

    @Mapping(target = "photo", ignore = true)
    Guest toDomain(GuestEntity entity);
}
