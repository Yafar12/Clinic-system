package com.clinic.system.dto.patient;

import com.clinic.system.model.Patient;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-19T10:29:18-0300",
    comments = "version: 1.5.4.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class PatientMapperImpl implements PatientMapper {

    @Override
    public PatientResponse toResponse(Patient entity) {
        if ( entity == null ) {
            return null;
        }

        Integer patientId = null;
        String email = null;
        String phone = null;
        String name = null;
        String lastName = null;

        patientId = entity.getPatientId();
        email = entity.getEmail();
        phone = entity.getPhone();
        name = entity.getName();
        lastName = entity.getLastName();

        PatientResponse patientResponse = new PatientResponse( patientId, email, phone, name, lastName );

        return patientResponse;
    }

    @Override
    public Patient toEntity(PatientRequest dto) {
        if ( dto == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setPatientId( dto.patientId() );
        patient.setName( dto.name() );
        patient.setLastName( dto.lastName() );
        patient.setEmail( dto.email() );
        patient.setPhone( dto.phone() );

        return patient;
    }

    @Override
    public void update(Patient entity, PatientRequest dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.name() != null ) {
            entity.setName( dto.name() );
        }
        if ( dto.lastName() != null ) {
            entity.setLastName( dto.lastName() );
        }
        if ( dto.email() != null ) {
            entity.setEmail( dto.email() );
        }
        if ( dto.phone() != null ) {
            entity.setPhone( dto.phone() );
        }
    }
}
