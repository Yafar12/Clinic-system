package com.project.project.application;

import com.project.project.application.dto.GuestCreatorCommand;
import com.project.project.application.dto.GuestCreatorResult;

public interface GuestCreator {
    GuestCreatorResult perform(GuestCreatorCommand command);
}
