package com.clinic.system.application;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PatientCreatorResult {

    private String uuid;
}
