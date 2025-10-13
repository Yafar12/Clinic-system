package com.clinic.system.domain.model;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Patient {

    private UUID uuid;
    private String dni;
    private String lastname;
    private String name;
    private String fotoPath;
}
