package com.clinic.system.infrastructure.adapters.input;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/patients")
@Validated
public class PatientPostAdapter {

    @PostMapping
    public ResponseEntity<PatientPostAdapterResponse> perform() {
        return ResponseEntity.ok().build();
    }

}
