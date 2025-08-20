package com.clinic.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.clinic.system.dto.doctor.DoctorCreateRequest;
import com.clinic.system.dto.doctor.DoctorMapper;
import com.clinic.system.dto.doctor.DoctorResponse;
import com.clinic.system.dto.doctor.DoctorUpdateRequest;
import com.clinic.system.exceptions.AppException;
import com.clinic.system.model.Doctor;
import com.clinic.system.repository.IDoctorRepository;

public class DoctorService implements IModelService<DoctorResponse, Long, DoctorCreateRequest, DoctorUpdateRequest> {

    @Autowired
    private IDoctorRepository repo;

    @Autowired
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
            throw AppException.badRequest("patientId inválido");
        if (repo.existsById(id))
            throw AppException.conflict("DNI ya registrado");
        Doctor doc = mapper.toentity(request);
        doc.setDni(id);
        try {
            return mapper.toResponse(repo.save(doc));
        } catch (DataIntegrityViolationException ex) {
            throw AppException.conflict("Violacion de unicidad");
        }

    }

    @Override
    public DoctorResponse update(Long ID, DoctorUpdateRequest request) {
        if (ID == null || ID <= 0)
            throw AppException.badRequest("id inválido");

        Doctor entity = repo.findById(ID)
                .orElseThrow(() -> AppException.notFound("Paciente %d no existe".formatted(ID)));

        mapper.update(entity, request);

        try {
            return mapper.toResponse(entity);
        } catch (Exception e) {
            throw AppException.conflict("Violacion de unicidad");
        }

    }

    @Override
    public void delete(Long ID) {
        repo.findById(ID).orElseThrow(() -> AppException.notFound("Numero de dni no encontrado"));
        repo.deleteById(ID);
    }

}
