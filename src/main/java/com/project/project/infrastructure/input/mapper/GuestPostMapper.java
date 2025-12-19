package com.project.project.infrastructure.input.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.project.project.application.dto.GuestCreatorCommand;
import com.project.project.application.dto.GuestCreatorResult;
import com.project.project.infrastructure.input.dto.GuestPostRequest;
import com.project.project.infrastructure.input.dto.GuestPostResponse;

@Mapper(componentModel = "spring", uses = GuestPhotoMapper.class)
public interface GuestPostMapper {

    @Mapping(target = "id", ignore = true)
    GuestCreatorCommand toCommand(GuestPostRequest request);

    GuestPostResponse toResponse(GuestCreatorResult result);

}
