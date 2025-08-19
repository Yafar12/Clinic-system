package com.clinic.system.dto.patient;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import com.clinic.system.model.Patient;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientResponse toResponse(Patient entity);

    Patient toEntity(PatientCreateRequest dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "patientId", ignore = true)
    void update(@MappingTarget Patient entity, PatientUpdateRequest dto);
}
