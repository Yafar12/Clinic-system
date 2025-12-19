package com.project.project.infrastructure.input.mapper;

import org.mapstruct.Mapper;

import com.project.project.application.dto.GuestGetByIdCommand;
import com.project.project.application.dto.GuestGetByIdResult;
import com.project.project.infrastructure.input.dto.GuestGetByIdRequest;
import com.project.project.infrastructure.input.dto.GuestGetByIdResponse;

@Mapper(componentModel = "spring")
public interface GuestGetByIdMapper {

    GuestGetByIdCommand toCommand(GuestGetByIdRequest request);

    GuestGetByIdResponse toResponse(GuestGetByIdResult result);
}
