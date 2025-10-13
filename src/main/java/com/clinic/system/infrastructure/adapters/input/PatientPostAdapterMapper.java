package com.clinic.system.infrastructure.adapters.input;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.clinic.system.application.PatientCreatorCommand;
import com.clinic.system.application.PatientCreatorResult;

@Mapper(componentModel = "spring")
public interface PatientPostAdapterMapper {

    @Mapping(source = "uuid", target = "uuid")
    PatientPostAdapterResponse toResponse(PatientCreatorResult patientCreatorResult);

    @Mapping(source = "uuid", target = "uuid")
    PatientCreatorCommand toCommand(PatientPostAdapterRequest request);
}
