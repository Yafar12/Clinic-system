package com.clinic.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.clinic.system.dto.doctor.DoctorCreateRequest;
import com.clinic.system.dto.doctor.DoctorResponse;
import com.clinic.system.dto.doctor.DoctorUpdateRequest;
import com.clinic.system.service.DoctorService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/doctors")
@Tag(name = "Doctors")
@Validated
public class DoctorController {

    @Autowired
    private DoctorService service;

    @GetMapping
    public ResponseEntity<List<DoctorResponse>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{DNI}")
    public ResponseEntity<DoctorResponse> findById(@PathVariable("DNI") Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<DoctorResponse> create(@Valid @RequestBody DoctorCreateRequest request){
        return ResponseEntity.status(201).body(service.create(request));
    }

    @PutMapping("/{DNI}")
    public ResponseEntity<DoctorResponse> update(@PathVariable("DNI") Long id,@Valid @RequestBody DoctorUpdateRequest request){
        return ResponseEntity.ok().body(service.update(id, request));
    }

    @DeleteMapping("/{DNI}")
    public ResponseEntity<Void> delete(@PathVariable("DNI") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
