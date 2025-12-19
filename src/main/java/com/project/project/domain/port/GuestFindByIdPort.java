package com.project.project.domain.port;

import java.util.Optional;

import com.project.project.domain.model.Guest;

public interface GuestFindByIdPort {
    Optional<Guest> findByDni(Integer dni);
}
