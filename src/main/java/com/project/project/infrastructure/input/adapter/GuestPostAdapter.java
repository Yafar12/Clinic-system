package com.project.project.infrastructure.input.adapter;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.project.application.GuestCreator;
import com.project.project.application.dto.GuestCreatorCommand;
import com.project.project.application.dto.GuestCreatorResult;
import com.project.project.infrastructure.input.dto.GuestPostAdapterRequest;
import com.project.project.infrastructure.input.dto.GuestPostAdapterResponse;
import com.project.project.infrastructure.input.mapper.GuestPostAdapterMapper;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Guest", description = "Endpoints para la gestion de invitados")
public class GuestPostAdapter {

    private final GuestPostAdapterMapper mapper;
    private final GuestCreator guestCreator;

    public GuestPostAdapter(GuestPostAdapterMapper mapper, GuestCreator creator) {
        this.mapper = mapper;
        this.guestCreator = creator;
    }

    @PostMapping("/guest")
    public GuestPostAdapterResponse perform(@RequestBody GuestPostAdapterRequest request) {
        GuestCreatorCommand command = mapper.toCommand(request);

        GuestCreatorResult result = guestCreator.perform(command);

        return mapper.toResponse(result);
    }

}
