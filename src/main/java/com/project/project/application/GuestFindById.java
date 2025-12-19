package com.project.project.application;

import com.project.project.application.dto.GuestGetByIdCommand;
import com.project.project.application.dto.GuestGetByIdResult;

public interface GuestFindById {
    GuestGetByIdResult perform(GuestGetByIdCommand command);
}
