package com.clinic.system.application;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PatientCreatorResult {

    private UUID uuid;
}
