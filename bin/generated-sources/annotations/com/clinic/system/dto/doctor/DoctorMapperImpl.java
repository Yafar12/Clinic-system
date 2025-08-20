package com.clinic.system.dto.doctor;

import com.clinic.system.model.Doctor;
import com.clinic.system.model.Specialty;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-20T09:34:36-0300",
    comments = "version: 1.5.4.Final, compiler: Eclipse JDT (IDE) 3.42.50.v20250729-0351, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class DoctorMapperImpl implements DoctorMapper {

    @Override
    public DoctorResponse toResponse(Doctor entity) {
        if ( entity == null ) {
            return null;
        }

        Long dni = null;
        String fullName = null;
        String licenseNumber = null;
        String email = null;
        String phone = null;
        String specialty = null;

        dni = entity.getDni();
        fullName = entity.getFullName();
        licenseNumber = entity.getLicenseNumber();
        email = entity.getEmail();
        phone = entity.getPhone();
        if ( entity.getSpecialty() != null ) {
            specialty = entity.getSpecialty().name();
        }

        DoctorResponse doctorResponse = new DoctorResponse( dni, fullName, licenseNumber, email, phone, specialty );

        return doctorResponse;
    }

    @Override
    public Doctor toentity(DoctorCreateRequest dto) {
        if ( dto == null ) {
            return null;
        }

        Doctor doctor = new Doctor();

        doctor.setDni( dto.dni() );
        doctor.setEmail( dto.email() );
        doctor.setFullName( dto.fullName() );
        doctor.setLicenseNumber( dto.licenseNumber() );
        doctor.setPhone( dto.phone() );
        if ( dto.specialty() != null ) {
            doctor.setSpecialty( Enum.valueOf( Specialty.class, dto.specialty() ) );
        }

        return doctor;
    }

    @Override
    public void update(Doctor entity, DoctorUpdateRequest dto) {
        if ( dto == null ) {
            return;
        }

        entity.setEmail( dto.email() );
        entity.setFullName( dto.fullName() );
        entity.setPhone( dto.phone() );
        if ( dto.specialty() != null ) {
            entity.setSpecialty( Enum.valueOf( Specialty.class, dto.specialty() ) );
        }
        else {
            entity.setSpecialty( null );
        }
    }
}
