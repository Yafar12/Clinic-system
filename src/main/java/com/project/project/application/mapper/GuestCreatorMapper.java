package com.project.project.application.mapper;

import org.mapstruct.Mapper;

import com.project.project.application.dto.GuestCreatorCommand;
import com.project.project.domain.model.Guest;

@Mapper(componentModel = "spring")
public interface GuestCreatorMapper {
    Guest toDomain(GuestCreatorCommand command);
}
