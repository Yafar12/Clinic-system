package com.clinic.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.clinic.system.dto.doctor.DoctorCreateRequest;
import com.clinic.system.dto.doctor.DoctorResponse;
import com.clinic.system.dto.doctor.DoctorUpdateRequest;
import com.clinic.system.dto.mapper.DoctorMapper;
import com.clinic.system.exceptions.AppException;
import com.clinic.system.model.Doctor;
import com.clinic.system.repository.IDoctorRepository;

@Service
public class DoctorService implements IModelService<DoctorResponse, Long, DoctorCreateRequest, DoctorUpdateRequest> {

    @Autowired
    private IDoctorRepository repo;

    @Autowired
    @Qualifier("doctorMapperV1Impl")
    private DoctorMapper mapper;

    @Override
    public List<DoctorResponse> findAll() {
        return repo.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public DoctorResponse findById(Long ID) {
        return repo.findById(ID).map(mapper::toResponse)
                .orElseThrow(() -> AppException.notFound("Numero de dni no encontrado"));
    }

    @Override
    public DoctorResponse create(DoctorCreateRequest request) {
        Long id = request.dni();
        if (id == null || id <= 0)
            throw AppException.badRequest("DNI invalido.");
        if (repo.existsById(id))
            throw AppException.conflict("DNI ya registrado");
        String email = (request.email() == null || request.email().isBlank()) ? null : request.email();
        if (repo.existsByEmailIgnoreCase(request.email()))
            throw AppException.conflict("El email ya esta registrado");
        String phone = (request.phone().isBlank() || request.phone() == null) ? null : request.phone();
        if (repo.existsByPhone(phone))
            throw AppException.conflict("El telefono ya esta registrado");

        Doctor doc = mapper.toEntity(request);
        doc.setDni(id);
        doc.setEmail(email);
        doc.setPhone(phone);
        return mapper.toResponse(repo.save(doc));

    }

    @Override
    public DoctorResponse update(Long ID, DoctorUpdateRequest request) {
        if (ID == null || ID <= 0)
            throw AppException.badRequest("id inválido");
        String email = (request.email() == null || request.email().isBlank()) ? null : request.email();
        if (request.email() != null && repo.existsByEmailAndDniNot(request.email(), ID))
            throw AppException.conflict("El email ya esta registrado");
        String phone = (request.phone().isBlank() || request.phone() == null) ? null : request.phone();
        if (repo.existsByPhone(phone))
            throw AppException.conflict("El telefono ya esta registrado");
        Doctor entity = repo.findById(ID)
                .orElseThrow(() -> AppException.notFound("Paciente %d no existe".formatted(ID)));

        mapper.update(entity, request);
        entity.setEmail(email);
        entity.setPhone(phone);
        return mapper.toResponse(repo.save(entity));

    }

    @Override
    public void delete(Long ID) {
        repo.findById(ID).orElseThrow(() -> AppException.notFound("Numero de dni no encontrado"));
        repo.deleteById(ID);
    }

}
