package com.project.project.application.useCase;

import org.springframework.stereotype.Service;

import com.project.project.application.GuestCreator;
import com.project.project.application.dto.GuestCreatorCommand;
import com.project.project.application.dto.GuestCreatorResult;
import com.project.project.application.mapper.GuestCreatorMapper;
import com.project.project.domain.model.Guest;
import com.project.project.domain.port.GuestCreatorPort;
import com.project.project.shared.error.DomainException;
import com.project.project.shared.error.ErrorCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GuestCreatorUseCase implements GuestCreator {
    private final GuestCreatorMapper mapper;
    private final GuestCreatorPort guestCreatorPort;

    @Override
    public GuestCreatorResult perform(GuestCreatorCommand command) {

        if (command.getDni() == null)
            throw new DomainException(ErrorCode.BAD_REQUEST, "El DNI es obligatorio");

        if (guestCreatorPort.existsByDni(command.getDni()))
            throw new DomainException(ErrorCode.CONFLICT, "El DNI ingresado ya existe");

        Guest guest = mapper.toDomain(command);

        Guest savedGuest = guestCreatorPort.perform(guest);

        GuestCreatorResult result = new GuestCreatorResult();
        result.setId(savedGuest.getId());

        return result;
    }
}
