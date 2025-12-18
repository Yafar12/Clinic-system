package com.project.project.application.useCase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.project.application.GuestFindAll;
import com.project.project.application.dto.GuestFindAllResult;
import com.project.project.application.mapper.GuestFindAllMapper;
import com.project.project.domain.model.Guest;
import com.project.project.domain.port.GuestFindAllPort;

@Service
public class GuestFindAllUseCase implements GuestFindAll {

    private final GuestFindAllPort guestFindAllPort;
    private final GuestFindAllMapper mapper;

    public GuestFindAllUseCase(GuestFindAllPort port, GuestFindAllMapper mapper) {
        this.guestFindAllPort = port;
        this.mapper = mapper;
    }

    @Override
    public List<GuestFindAllResult> perform() {
        List<Guest> guests = guestFindAllPort.perform();

        return mapper.toResultList(guests);
    }
}