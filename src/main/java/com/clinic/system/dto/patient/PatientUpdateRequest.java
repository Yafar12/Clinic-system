package com.clinic.system.dto.patient;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PatientUpdateRequest(
        @NotBlank @Size(min = 3, max = 70) String name,
        @JsonProperty("last_name") @NotBlank @Size(min = 2, max = 70) String lastName,
        @NotBlank @Email String email,
        @NotBlank @Size(min = 7, max = 12) String phone) {
}
