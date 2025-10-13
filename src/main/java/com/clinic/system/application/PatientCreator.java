package com.clinic.system.application;

public interface PatientCreator {
    PatientCreatorResult perform(PatientCreatorCommand patientCreatorCommand);
}
