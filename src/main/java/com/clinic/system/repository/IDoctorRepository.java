package com.clinic.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinic.system.model.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor,Long>{
    
}
