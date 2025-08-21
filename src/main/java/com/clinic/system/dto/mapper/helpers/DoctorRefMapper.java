package com.clinic.system.dto.mapper.helpers;

import org.springframework.stereotype.Component;
import com.clinic.system.exceptions.AppException;
import com.clinic.system.model.Doctor;
import com.clinic.system.repository.IDoctorRepository;

@Component
public class DoctorRefMapper {
    private final IDoctorRepository doctorRepo;

    public DoctorRefMapper(IDoctorRepository doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    public Doctor fromDni(Long dni) {
        if (dni == null)
            throw AppException.badRequest("dni de doctor requerido");
        return doctorRepo.findById(dni).orElseThrow(() -> AppException.notFound("Doctor %d no existe".formatted(dni)));
    }

    public Long toDni(Doctor doctor) {
        return doctor != null ? doctor.getDni() : null;
    }
}