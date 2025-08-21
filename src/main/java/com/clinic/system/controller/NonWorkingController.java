package com.clinic.system.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clinic.system.dto.nonWorkingDay.NonWorkingResponse;
import com.clinic.system.service.NonWorkingDayService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/non-working-days")
@Tag(name = "Non Working Days")
public class NonWorkingController {

    @Autowired
    private NonWorkingDayService service;

    @GetMapping("/{DNI}")
    public ResponseEntity<List<NonWorkingResponse>> findByDoctor(@PathVariable("DNI") Long id, @RequestParam LocalDate date){
        List<NonWorkingResponse> res = service.listByDoctorAndDate(id, date);

        if(res.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(res);
    }
}
