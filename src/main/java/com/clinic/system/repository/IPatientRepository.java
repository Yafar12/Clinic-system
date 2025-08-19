package com.clinic.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinic.system.model.Patient;

public interface IPatientRepository extends JpaRepository<Patient,Long>{

    boolean existsByEmail(String email);

    boolean existsByEmailAndPatientIdNot(String email,Long id);

    boolean existsByEmailIgnoreCase(String email);

    boolean existsByEmailIgnoreCaseAndPatientIdNot(String email, Long patientId);

}
