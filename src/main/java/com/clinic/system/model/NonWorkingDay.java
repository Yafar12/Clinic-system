package com.clinic.system.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "non_working_blocks")
@Data
public class NonWorkingDay {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "dni", nullable = false)
  private Doctor doctor;

  @Column(nullable = false)
  private LocalDate date; 

  private LocalTime startTime;
  private LocalTime endTime;

  @Size(max = 160)
  private String reason; 


}
