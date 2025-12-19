package com.project.project.infrastructure.input.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.project.project.application.dto.GuestFindAllResult;
import com.project.project.infrastructure.input.dto.GuestGetAllResponse;

@Mapper(componentModel = "spring")
public interface GuestGetAllMapper {

    GuestGetAllResponse toResponse(GuestFindAllResult result);

    List<GuestGetAllResponse> toResponse(List<GuestFindAllResult> result);
}
