package com.clinic.system.dto.mapper;

import com.clinic.system.dto.patient.PatientCreateRequest;
import com.clinic.system.dto.patient.PatientResponse;
import com.clinic.system.dto.patient.PatientUpdateRequest;
import com.clinic.system.model.Patient;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-21T08:10:09-0300",
    comments = "version: 1.5.4.Final, compiler: Eclipse JDT (IDE) 3.42.50.v20250729-0351, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class PatientMapperV1Impl implements PatientMapper {

    @Override
    public PatientResponse toResponse(Patient entity) {
        if ( entity == null ) {
            return null;
        }

        Long patientId = null;
        String name = null;
        String lastName = null;
        String email = null;
        String phone = null;

        patientId = entity.getPatientId();
        name = entity.getName();
        lastName = entity.getLastName();
        email = entity.getEmail();
        phone = entity.getPhone();

        PatientResponse patientResponse = new PatientResponse( patientId, name, lastName, email, phone );

        return patientResponse;
    }

    @Override
    public Patient toEntity(PatientCreateRequest dto) {
        if ( dto == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setEmail( dto.email() );
        patient.setLastName( dto.lastName() );
        patient.setName( dto.name() );
        patient.setPatientId( dto.patientId() );
        patient.setPhone( dto.phone() );

        return patient;
    }

    @Override
    public void update(Patient entity, PatientUpdateRequest dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.email() != null ) {
            entity.setEmail( dto.email() );
        }
        if ( dto.lastName() != null ) {
            entity.setLastName( dto.lastName() );
        }
        if ( dto.name() != null ) {
            entity.setName( dto.name() );
        }
        if ( dto.phone() != null ) {
            entity.setPhone( dto.phone() );
        }
    }
}
