package com.clinic.system.dto.mapper;

import com.clinic.system.dto.doctor.DoctorCreateRequest;
import com.clinic.system.dto.doctor.DoctorResponse;
import com.clinic.system.dto.doctor.DoctorUpdateRequest;
import com.clinic.system.model.Doctor;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-21T07:59:30-0300",
    comments = "version: 1.5.4.Final, compiler: Eclipse JDT (IDE) 3.42.50.v20250729-0351, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class DoctorMapperV1Impl implements DoctorMapper {

    @Override
    public DoctorResponse toResponse(Doctor entity) {
        if ( entity == null ) {
            return null;
        }

        String specialty = null;
        Long dni = null;
        String fullName = null;
        String licenseNumber = null;
        String email = null;
        String phone = null;

        if ( entity.getSpecialty() != null ) {
            specialty = entity.getSpecialty().name();
        }
        dni = entity.getDni();
        fullName = entity.getFullName();
        licenseNumber = entity.getLicenseNumber();
        email = entity.getEmail();
        phone = entity.getPhone();

        DoctorResponse doctorResponse = new DoctorResponse( dni, fullName, licenseNumber, email, phone, specialty );

        return doctorResponse;
    }

    @Override
    public Doctor toEntity(DoctorCreateRequest dto) {
        if ( dto == null ) {
            return null;
        }

        Doctor doctor = new Doctor();

        doctor.setSpecialty( dto.specialty() );
        doctor.setDni( dto.dni() );
        doctor.setEmail( dto.email() );
        doctor.setFullName( dto.fullName() );
        doctor.setLicenseNumber( dto.licenseNumber() );
        doctor.setPhone( dto.phone() );

        return doctor;
    }

    @Override
    public void update(Doctor entity, DoctorUpdateRequest dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.email() != null ) {
            entity.setEmail( dto.email() );
        }
        if ( dto.fullName() != null ) {
            entity.setFullName( dto.fullName() );
        }
        if ( dto.phone() != null ) {
            entity.setPhone( dto.phone() );
        }
        if ( dto.specialty() != null ) {
            entity.setSpecialty( dto.specialty() );
        }
    }
}
