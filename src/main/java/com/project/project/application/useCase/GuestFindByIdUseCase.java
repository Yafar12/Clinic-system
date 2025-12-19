package com.project.project.application.useCase;

import org.springframework.stereotype.Service;

import com.project.project.application.GuestFindById;
import com.project.project.application.dto.GuestGetByIdCommand;
import com.project.project.application.dto.GuestGetByIdResult;
import com.project.project.application.mapper.GuestFindByIdMapper;
import com.project.project.domain.model.Guest;
import com.project.project.domain.port.GuestFindByIdPort;
import com.project.project.shared.error.DomainException;
import com.project.project.shared.error.ErrorCode;

@Service
public class GuestFindByIdUseCase implements GuestFindById {

    private final GuestFindByIdMapper mapper;
    private final GuestFindByIdPort guestFindByIdPort;

    public GuestFindByIdUseCase(GuestFindByIdMapper mapper, GuestFindByIdPort port) {
        this.guestFindByIdPort = port;
        this.mapper = mapper;
    }

    @Override
    public GuestGetByIdResult perform(GuestGetByIdCommand command) {
        Guest guest = guestFindByIdPort.findByDni(command.getDni()).orElseThrow(
                () -> new DomainException(ErrorCode.NOT_FOUND, "No se encontro el dni " + command.getDni()));

        return mapper.toResult(guest);
    }
}
