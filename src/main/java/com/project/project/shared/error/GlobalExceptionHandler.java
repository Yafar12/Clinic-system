package com.project.project.shared.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ErrorResponse> handleDomainException(DomainException ex) {
        ErrorCode error = ex.getErrorCode();
        ErrorResponse response = ErrorResponse.builder()
                .code(error.getCode())
                .description(ex.getMessage())
                .build();

        return new ResponseEntity<>(response, error.getStatus());
    }
}
