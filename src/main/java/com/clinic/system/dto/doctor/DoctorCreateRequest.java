package com.clinic.system.dto.doctor;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DoctorCreateRequest(
        @JsonProperty("DNI") Long dni,
        String fullName,
        String licenseNumber,
        String email,
        String phone,
        String specialty) {

}
