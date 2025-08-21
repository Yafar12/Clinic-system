package com.clinic.system.dto.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.clinic.system.dto.patient.PatientCreateRequest;
import com.clinic.system.dto.patient.PatientResponse;
import com.clinic.system.dto.patient.PatientUpdateRequest;
import com.clinic.system.model.Patient;

@Mapper(componentModel = "spring", implementationName = "PatientMapperV1Impl")
public interface PatientMapper {

    PatientResponse toResponse(Patient entity);

    Patient toEntity(PatientCreateRequest dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "patientId", ignore = true)
    void update(@MappingTarget Patient entity, PatientUpdateRequest dto);
}
