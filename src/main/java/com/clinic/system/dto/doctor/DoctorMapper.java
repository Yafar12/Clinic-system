package com.clinic.system.dto.doctor;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.context.annotation.Bean;

import com.clinic.system.model.Doctor;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    DoctorResponse toResponse(Doctor entity);

    Doctor toentity(DoctorCreateRequest dto);

    @Bean
    @Mapping(target = "dni", ignore = true)
    @Mapping(target = "licenseNumber", ignore = true)
    void update(@MappingTarget Doctor entity, DoctorUpdateRequest dto);
}
