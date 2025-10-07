package com.clinic.system.infrastructure.adapters.input.rest;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientPostAdapterRequest {
    @NotBlank(message = "must not be null")
    private String uuid;
    @NotBlank(message = "must not be null")
    @Size(min = 2, max = 50)
    private String name;
    @Email
    @NotBlank(message = "must not be null")
    private String email;
    @Size(min = 7, max = 20)
    private String phone;

}
