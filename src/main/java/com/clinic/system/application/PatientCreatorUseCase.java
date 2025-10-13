package com.clinic.system.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clinic.system.domain.model.Patient;
import com.clinic.system.domain.output.FileManagerPort;
import com.clinic.system.domain.output.PatientCreatorPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientCreatorUseCase {

    private final PatientCreatorPort patientCreatorPort;
    private final PatientCreatorMapper mapper;
    private final FileManagerPort fileManagerPort;

    @Transactional
    public PatientCreatorResult perform(PatientCreatorCommand command) {
        try {
            String savePath = null;
            if (command.getFoto() != null && command.getFotoFilname() != null) {
                savePath = fileManagerPort.perform(command.getFoto(), command.getFotoFilname());
            }

            Patient patientToSave = mapper.toDomanin(command);
            patientToSave.setFotoPath(savePath);

            Patient saved = patientCreatorPort.perform(patientToSave, command.getFoto(), command.getFotoFilname());

            return PatientCreatorResult.builder().uuid(saved.getUuid()).build();
        } catch (Exception e) {
            throw new RuntimeException("Error creando patient", e);
        }
    }
}
