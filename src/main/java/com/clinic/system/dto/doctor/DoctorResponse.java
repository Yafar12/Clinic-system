package com.clinic.system.dto.doctor;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DoctorResponse(
                @JsonProperty("DNI") Long dni,
                @JsonProperty("full_name") String fullName,
                @JsonProperty("license_number") String licenseNumber,
                String email,
                String phone,
                String specialty

) {

}
