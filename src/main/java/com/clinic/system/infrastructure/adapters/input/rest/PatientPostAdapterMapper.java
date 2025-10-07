package com.clinic.system.infrastructure.adapters.input.rest;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PatientPostAdapterMapper {

    @Mapping(source = "uuid", target = "uuid")
    PatientPostAdapterResponse toResponse(PatientPostAdapterRequest request);
}
