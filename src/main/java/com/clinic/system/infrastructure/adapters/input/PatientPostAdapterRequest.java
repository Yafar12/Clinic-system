package com.clinic.system.infrastructure.adapters.input;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientPostAdapterRequest {

    private String uuid;
    private String name;
    private String lastname;
    private MultipartFile foto;

}
