package com.clinic.system.dto.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.clinic.system.dto.doctor.DoctorCreateRequest;
import com.clinic.system.dto.doctor.DoctorResponse;
import com.clinic.system.dto.doctor.DoctorUpdateRequest;
import com.clinic.system.model.Doctor;

@Mapper(
    componentModel = "spring",
    implementationName = "DoctorMapperV1Impl"
)
public interface DoctorMapper {

    @Mapping(source = "specialty", target = "specialty")
    DoctorResponse toResponse(Doctor entity);

    @Mapping(source = "specialty", target = "specialty")
    Doctor toEntity(DoctorCreateRequest dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "dni", ignore = true)
    @Mapping(target = "licenseNumber", ignore = true)
    void update(@MappingTarget Doctor entity, DoctorUpdateRequest dto);
}
