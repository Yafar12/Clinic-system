package com.clinic.system.application;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.clinic.system.domain.model.Patient;

@Mapper
public interface PatientCreatorMapper {

    @Mapping(source = "uuid", target = "uuid")
    Patient toDomanin(PatientCreatorCommand command);

}
