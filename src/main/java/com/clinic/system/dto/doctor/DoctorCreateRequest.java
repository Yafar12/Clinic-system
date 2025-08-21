package com.clinic.system.dto.doctor;

import com.clinic.system.model.Specialty;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record DoctorCreateRequest(
                @JsonProperty("DNI") @NotNull @Positive Long dni,
                @JsonProperty("full_name") @NotBlank @Size(min = 2, max = 120) String fullName,
                @JsonProperty("license_number") @NotBlank @Size(min = 4, max = 40) String licenseNumber,
                @Email @Size(max = 120) String email,
                @Size(max = 40) String phone,
                @NotNull Specialty specialty) {
}
