package com.clinic.system.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorResponse> handleAppException(AppException ex) {
        var status = ex.getStatus();
        var body = new ErrorResponse(
            ex.getTimestamp(), 
            status.value(), 
            status.getReasonPhrase(), 
            ex.getMessage(),
            ex.getViolation());

        return ResponseEntity.status(status).body(body);
    }
}
