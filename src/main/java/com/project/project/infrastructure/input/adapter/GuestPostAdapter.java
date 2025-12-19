package com.project.project.infrastructure.input.adapter;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.project.application.GuestCreator;
import com.project.project.application.dto.GuestCreatorCommand;
import com.project.project.application.dto.GuestCreatorResult;
import com.project.project.infrastructure.input.dto.GuestPostRequest;
import com.project.project.infrastructure.input.dto.GuestPostResponse;
import com.project.project.infrastructure.input.mapper.GuestPostMapper;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Guest", description = "Endpoints para la gestion de invitados")
public class GuestPostAdapter {

    private final GuestPostMapper mapper;
    private final GuestCreator guestCreator;

    public GuestPostAdapter(GuestPostMapper mapper, GuestCreator creator) {
        this.mapper = mapper;
        this.guestCreator = creator;
    }

    @PostMapping("/guest")
    public GuestPostResponse perform(@RequestBody GuestPostRequest request) {
        GuestCreatorCommand command = mapper.toCommand(request);

        GuestCreatorResult result = guestCreator.perform(command);

        return mapper.toResponse(result);
    }

}
