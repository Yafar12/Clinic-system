package com.clinic.system.dto.nonWorkingDay;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NonWorkingCreateRequest(
                @NotNull Long dni,
                @NotNull LocalDate date,
                LocalTime startTime,
                LocalTime endTime,
                @Size(max = 160) String reason) {
}