package com.clinic.system.domain.output;

import com.clinic.system.domain.model.Patient;

public interface PatientCreatorPort {
    Patient perform(Patient patient, byte[] photoBytes, String photoOriginalName);
}
