package com.clinic.system.dto.nonWorkingDay;

import java.time.LocalDate;
import java.time.LocalTime;


public record NonWorkingResponse(
                Integer id,
                Long dni,
                LocalDate date,
                LocalTime startTime,
                LocalTime endTime,
                String reason) {
}
