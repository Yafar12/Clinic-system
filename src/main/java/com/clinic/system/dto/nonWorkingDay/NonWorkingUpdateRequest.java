package com.clinic.system.dto.nonWorkingDay;


import java.time.LocalTime;

import jakarta.validation.constraints.Size;

public record NonWorkingUpdateRequest(
        @Size(max = 160) String reason,
        LocalTime startTime,
        LocalTime endTime) {
}
