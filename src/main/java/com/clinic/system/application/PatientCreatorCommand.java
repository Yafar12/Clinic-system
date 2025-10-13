package com.clinic.system.application;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatientCreatorCommand {

    private String uuid;
    private String dni;
    private String lastname;
    private String name;
    private byte[] foto;
    private String fotoFilname;
}
