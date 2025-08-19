package com.clinic.system.exceptions;

public record FieldViolation(
        String field,
        String message,
        Object rejectedValue) {

}
