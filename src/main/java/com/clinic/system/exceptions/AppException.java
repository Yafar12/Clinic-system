package com.clinic.system.exceptions;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException {

    private final Instant timestamp = Instant.now();
    private final HttpStatus status;
    private final String message;
    private final List<FieldViolation> violations;

    public AppException(HttpStatus status, String message) {
        this(status, message, List.of(), null);
    }

    public AppException(HttpStatus status, String message, Throwable cause) {
        this(status, message, List.of(), cause);
    }

    public AppException(HttpStatus status, String message, List<FieldViolation> violations) {
        this(status, message, violations, null);
    }

    public AppException(HttpStatus status, String message,
            List<FieldViolation> violations, Throwable cause) {
        super(message, cause);
        this.status = Objects.requireNonNull(status, "status");
        this.message = (message == null || message.isBlank())
                ? status.getReasonPhrase()
                : message;
        this.violations = violations == null ? List.of() : List.copyOf(violations);
    }

    public static AppException badRequest(String msg) {
        return new AppException(HttpStatus.BAD_REQUEST, msg);
    }

    public static AppException notFound(String msg) {
        return new AppException(HttpStatus.NOT_FOUND, msg);
    }

    public static AppException conflict(String msg) {
        return new AppException(HttpStatus.CONFLICT, msg);
    }

    public static AppException badRequest(String msg, List<FieldViolation> v) {
        return new AppException(HttpStatus.BAD_REQUEST, msg, v);
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public List<FieldViolation> getViolation() {
        return violations;
    }
}
