package com.project.project.domain.port;

import com.project.project.domain.model.Guest;

public interface GuestCreatorPort {
    Guest perform(Guest guest);

    boolean existsByDni(Integer dni);
}
