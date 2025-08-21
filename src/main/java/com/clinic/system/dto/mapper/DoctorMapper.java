package com.clinic.system.dto.mapper;

import org.springframework.stereotype.Component;

import com.clinic.system.dto.doctor.DoctorCreateRequest;
import com.clinic.system.dto.doctor.DoctorResponse;
import com.clinic.system.dto.doctor.DoctorUpdateRequest;
import com.clinic.system.model.Doctor;

@Component
public class DoctorMapper {

    public DoctorResponse toResponse(Doctor entity) {
        if (entity == null)
            return null;
        return new DoctorResponse(
                entity.getDni(),
                entity.getFullName(),
                entity.getLicenseNumber(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getSpecialty().name());
    }

    public Doctor toEntity(DoctorCreateRequest dto) {
        if (dto == null)
            return null;
        Doctor doc = new Doctor();
        doc.setDni(dto.dni());
        doc.setFullName(dto.fullName());
        doc.setLicenseNumber(dto.licenseNumber());
        doc.setSpecialty(dto.specialty());
        doc.setEmail(dto.email());
        doc.setPhone(dto.phone());
        return doc;
    }

    public void update(Doctor target, DoctorUpdateRequest dto) {
        if (target == null || dto == null)
            return;
        if (hasText(dto.fullName()))
            target.setFullName(dto.fullName());
        if (hasText(dto.email()))
            target.setEmail(dto.email().trim());
        if (hasText(dto.phone()))
            target.setPhone(dto.phone().trim());
        if (hasText(dto.specialty().name()))
            target.setSpecialty(dto.specialty());
    }

    private static boolean hasText(String s) {
        return s != null && !s.isEmpty();
    }
}
