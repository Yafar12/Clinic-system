package com.clinic.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinic.system.dto.patient.PatientCreateRequest;
import com.clinic.system.dto.patient.PatientResponse;
import com.clinic.system.dto.patient.PatientUpdateRequest;
import com.clinic.system.service.PatientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/patients")
@Tag(name = "Patients")
@Validated
public class PatientController {

    @Autowired
    private PatientService service;

    @GetMapping
    @Operation(summary = "Listar todos los pacientes")
    public ResponseEntity<List<PatientResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{DNI}")
    public ResponseEntity<PatientResponse> findById(@PathVariable("DNI") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<PatientResponse> create(@Valid @RequestBody PatientCreateRequest request) {
        PatientResponse resp = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @PutMapping("/{DNI}")
    public ResponseEntity<PatientResponse> update(@PathVariable("DNI") Long id,
            @Valid @RequestBody PatientUpdateRequest request) {
        PatientResponse resp = service.update(id, request);
        return ResponseEntity.status(200).body(resp);
    }

    @DeleteMapping("/{DNI}")
    public ResponseEntity<Void> delete(@PathVariable("DNI") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
