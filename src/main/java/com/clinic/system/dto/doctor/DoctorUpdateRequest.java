package com.clinic.system.dto.doctor;


public record DoctorUpdateRequest(
        String fullName,
        String email,
        String phone,
        String specialty) {

}
