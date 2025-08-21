package com.clinic.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinic.system.model.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor,Long>{
    boolean existsByEmail(String email);

    boolean existsByEmailAndDniNot(String email,Long id);

    boolean existsByEmailIgnoreCase(String email);

    boolean existsByPhone(String phone);
}
