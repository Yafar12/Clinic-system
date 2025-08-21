package com.clinic.system.dto.doctor;

import com.clinic.system.model.Specialty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record DoctorUpdateRequest(
    @Size(min=2, max=120) String fullName,
    @Email String email,
    @Size(max=40) String phone,
    Specialty specialty
) {}

