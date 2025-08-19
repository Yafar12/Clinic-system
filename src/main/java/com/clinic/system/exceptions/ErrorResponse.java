package com.clinic.system.exceptions;

import java.time.Instant;
import java.util.List;


public record ErrorResponse(
        Instant timestamp,
        int status,
        String error,
        String message,
        List<FieldViolation> violations) {
}
