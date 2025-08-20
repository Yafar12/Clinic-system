package com.clinic.system.model;

import java.time.Instant;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "doctors",
  uniqueConstraints = {
    @UniqueConstraint(name="uk_doctors_dni", columnNames="dni"),
    @UniqueConstraint(name="uk_doctors_license", columnNames="license_number")
})
@Data
public class Doctor {

  @Id @Size(min=6, max=20)
  private Long dni;

  @NotBlank @Size(min=2, max=120)
  private String fullName;

  @NotBlank @Size(min=4, max=40)
  private String licenseNumber;

  @Email @Size(max=120)
  private String email;

  @Size(max=40)
  private String phone;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Specialty specialty;

  @Column(nullable = false, updatable = false)
  private Instant createdAt = Instant.now();

  @Column(nullable = false)
  private Instant updatedAt = Instant.now();

  @PreUpdate
  public void preUpdate(){ updatedAt = Instant.now(); }

}

