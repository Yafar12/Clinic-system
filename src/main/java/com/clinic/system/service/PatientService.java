package com.clinic.system.service;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.clinic.system.dto.mapper.PatientMapper;
import com.clinic.system.dto.patient.PatientCreateRequest;
import com.clinic.system.dto.patient.PatientResponse;
import com.clinic.system.dto.patient.PatientUpdateRequest;
import com.clinic.system.exceptions.AppException;
import com.clinic.system.model.Patient;
import com.clinic.system.repository.IPatientRepository;

import jakarta.transaction.Transactional;

@Service
public class PatientService
        implements IModelService<PatientResponse, Long, PatientCreateRequest, PatientUpdateRequest> {

    @Autowired
    private IPatientRepository repo;
    @Autowired
    @Qualifier("patientMapperV1Impl")
    private PatientMapper mapper;

    @Override
    public List<PatientResponse> findAll() {
        return repo.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public PatientResponse findById(Long id) {
        return repo.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> AppException.notFound("DNI no encontrado"));
    }

    @Override
    public PatientResponse create(PatientCreateRequest request) {
        Long id = request.patientId();
        if (id == null || id <= 0)
            throw AppException.badRequest("patientId inválido");
        if (repo.existsById(id))
            throw AppException.conflict("DNI ya registrado");

        String email = request.email();
        if (email == null || email.isBlank())
            throw AppException.badRequest("email requerido");
        email = email.trim().toLowerCase(Locale.ROOT);
        if (repo.existsByEmailIgnoreCase(email))
            throw AppException.conflict("email ya registrado");
        String phone = request.phone();
        if (phone == null || phone.isBlank())
            throw AppException.badRequest("phone requerido");

        Patient p = mapper.toEntity(request);
        p.setEmail(email);
        try {
            return mapper.toResponse(repo.save(p));
        } catch (DataIntegrityViolationException e) {
            throw AppException.conflict("Violación de unicidad");
        }
    }

    @Transactional
    public PatientResponse update(Long id, PatientUpdateRequest request) {
        if (id == null || id <= 0)
            throw AppException.badRequest("id inválido");

        Patient entity = repo.findById(id)
                .orElseThrow(() -> AppException.notFound("Paciente %d no existe".formatted(id)));

        String email = request.email();
        if (email == null || email.isBlank())
            throw AppException.badRequest("email requerido");
        email = email.trim().toLowerCase(Locale.ROOT);

        if (!email.equalsIgnoreCase(entity.getEmail())
                && repo.existsByEmailIgnoreCaseAndPatientIdNot(email, id)) {
            throw AppException.conflict("email ya registrado");
        }

        String phone = request.phone();
        if (phone == null || phone.isBlank())
            throw AppException.badRequest("phone requerido");

        mapper.update(entity, request);
        entity.setEmail(email);
        entity.setPhone(phone.trim());

        try {
            return mapper.toResponse(repo.save(entity));
        } catch (DataIntegrityViolationException e) {
            throw AppException.conflict("Violación de unicidad");
        }

    }

    @Override
    public void delete(Long ID) {
        repo.findById(ID).orElseThrow(() -> AppException.notFound("DNI no se encontro."));
        repo.deleteById(ID);
    }

}
