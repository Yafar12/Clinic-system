package com.project.project.domain.port;

import java.util.List;

import com.project.project.domain.model.Guest;

public interface GuestFindAllPort {

    List<Guest> perform();
}
