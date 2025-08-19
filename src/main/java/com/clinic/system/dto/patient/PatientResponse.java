package com.clinic.system.dto.patient;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PatientResponse(
        @JsonProperty("DNI") Long patientId,
        String name,
        @JsonProperty("last_name") String lastName,
        String email,
        String phone) {

}
