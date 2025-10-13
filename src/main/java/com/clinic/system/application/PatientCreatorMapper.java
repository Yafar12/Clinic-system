package com.clinic.system.application;

import org.mapstruct.Mapper;

import com.clinic.system.domain.model.Patient;

@Mapper
public interface PatientCreatorMapper {

    Patient toDomanin(PatientCreatorCommand command);

}
