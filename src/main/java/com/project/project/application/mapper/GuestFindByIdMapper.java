package com.project.project.application.mapper;

import org.mapstruct.Mapper;

import com.project.project.application.dto.GuestGetByIdResult;
import com.project.project.domain.model.Guest;

@Mapper(componentModel = "spring")
public interface GuestFindByIdMapper {

    GuestGetByIdResult toResult(Guest guest);
}
