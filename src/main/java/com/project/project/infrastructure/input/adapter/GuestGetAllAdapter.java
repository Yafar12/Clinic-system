package com.project.project.infrastructure.input.adapter;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.project.application.GuestFindAll;
import com.project.project.application.dto.GuestFindAllResult;
import com.project.project.infrastructure.input.dto.GuestGetAllAdapterResponse;
import com.project.project.infrastructure.input.mapper.GuestGetAllAdapterMapper;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Guest", description = "Endpoints para la gestion de invitados")

public class GuestGetAllAdapter {

    private final GuestFindAll guestFindAll;
    private final GuestGetAllAdapterMapper mapper;

    public GuestGetAllAdapter(GuestFindAll guestFindAll, GuestGetAllAdapterMapper mapper) {
        this.guestFindAll = guestFindAll;
        this.mapper = mapper;
    }

    @GetMapping("/guests")
    public ResponseEntity<List<GuestGetAllAdapterResponse>> perform() {
        List<GuestFindAllResult> results = guestFindAll.perform();
        return ResponseEntity.ok(mapper.toResponse(results));
    }
}
