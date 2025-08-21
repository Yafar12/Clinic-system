package com.clinic.system.dto.nonWorkingDay;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;


public record NonWorkingResponse(
                Integer id,
                Long dni,
                LocalDate date,
                LocalTime startTime,
                LocalTime endTime,
               @NotBlank(message = "La razon es obligatoria.") String reason) {
}
