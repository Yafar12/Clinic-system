package com.clinic.system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "Patients")
@Data
public class Patient {
    @Id
    @Column()
    private Long patientId;

    @Column(nullable = false)
    @Size(min = 3, max = 70)
    @NotBlank

    private String name;

    @Column(nullable = false)
    @Size(min = 2, max = 70)
    @NotBlank

    private String lastName;

    @Column(nullable = false)
    @Email
    @NotBlank

    private String email;

    @Column(nullable = false)
    @Size(min = 7, max = 12)
    @NotBlank

    private String phone;
}
