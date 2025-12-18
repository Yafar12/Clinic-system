package com.project.project.infrastructure.input.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.project.project.application.dto.GuestFindAllResult;
import com.project.project.infrastructure.input.dto.GuestGetAllAdapterResponse;

@Mapper(componentModel = "spring")
public interface GuestGetAllAdapterMapper {

    List<GuestGetAllAdapterResponse> toResponse(List<GuestFindAllResult> result);
}
