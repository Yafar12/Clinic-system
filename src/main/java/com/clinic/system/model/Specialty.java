package com.clinic.system.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Specialty {
    CLINIC,
    PEDIATRICS,
    CARDIOLOGY,
    DERMATOLOGY,
    GYNECOLOGY,
    TRAUMATOLOGY,
    NEUROLOGY,
    PSYCHIATRY;

    @JsonCreator
  public static Specialty from(String v) {
    return Specialty.valueOf(v.trim().toUpperCase());
  }
}
