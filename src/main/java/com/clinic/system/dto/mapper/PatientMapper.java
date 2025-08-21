package com.clinic.system.dto.mapper;

import com.clinic.system.dto.patient.PatientCreateRequest;
import com.clinic.system.dto.patient.PatientResponse;
import com.clinic.system.dto.patient.PatientUpdateRequest;
import com.clinic.system.model.Patient;

public class PatientMapper {

    public PatientResponse toResponse(Patient entity) {
        if (entity == null)
            return null;
        return new PatientResponse(
                entity.getPatientId(),
                entity.getName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getPhone());
    }

    public Patient toEntity(PatientCreateRequest dto){
        if(dto == null) return null;
        Patient pat = new Patient();
        pat.setEmail(dto.email());
        pat.setPhone(dto.phone());
        pat.setLastName(dto.lastName());
        pat.setName(dto.name());
        pat.setPatientId(dto.patientId());

        return pat;
    }

    public void update(Patient target, PatientUpdateRequest dto){
        if(target == null || dto == null) return;

        if(hasText(dto.name())) target.getName();
        if(hasText(dto.lastName()))  target.getLastName();
        if(hasText(dto.email())) target.getEmail();
        if(hasText(dto.phone())) target.getPhone();
    }

    private static boolean hasText(String s){
        return s != null && !s.isEmpty();
    }
}
