package com.clinic.system.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinic.system.model.NonWorkingDay;

public interface INonWorkingDayRepository extends JpaRepository<NonWorkingDay, Integer> {

  
  List<NonWorkingDay> findByDoctor_DniAndDate(Long dni, LocalDate date);

  
  List<NonWorkingDay> findByDoctor_DniAndDateBetween(Long dni, LocalDate start, LocalDate end);

  
  boolean existsByDoctor_DniAndDateAndStartTimeAndEndTime(Long dni, LocalDate date, java.time.LocalTime start, java.time.LocalTime end);

  
  boolean existsByDoctor_DniAndDateAndStartTimeIsNullAndEndTimeIsNull(Long dni, LocalDate date);
}
