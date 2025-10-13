package com.clinic.system.infrastructure.adapters.input;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatientPostAdapterResponse {
    private UUID uuid;

}
