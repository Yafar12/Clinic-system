package com.project.project.infrastructure.input.adapter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.project.application.GuestFindById;
import com.project.project.application.dto.GuestGetByIdCommand;
import com.project.project.application.dto.GuestGetByIdResult;
import com.project.project.infrastructure.input.dto.GuestGetByIdRequest;
import com.project.project.infrastructure.input.dto.GuestGetByIdResponse;
import com.project.project.infrastructure.input.mapper.GuestGetByIdMapper;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Guest")
public class GuestGetByDniAdapter {

    private final GuestGetByIdMapper mapper;
    private final GuestFindById guestFindById;

    public GuestGetByDniAdapter(GuestGetByIdMapper mapper, GuestFindById guestFindById) {
        this.guestFindById = guestFindById;
        this.mapper = mapper;
    }

    @GetMapping("/guests/{dni}")
    public ResponseEntity<GuestGetByIdResponse> perform(@PathVariable("dni") Integer dni) {
        GuestGetByIdRequest request = new GuestGetByIdRequest(dni);

        GuestGetByIdCommand command = mapper.toCommand(request);

        GuestGetByIdResult result = guestFindById.perform(command);

        return ResponseEntity.ok(mapper.toResponse(result));
    }
}
