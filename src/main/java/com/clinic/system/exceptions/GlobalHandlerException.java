package com.clinic.system.exceptions;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorResponse> handlerAppException(AppException ex) {
        var status = ex.getStatus();
        var body = new ErrorResponse(
                ex.getTimestamp(),
                status.value(),
                status.getReasonPhrase(),
                ex.getMessage(),
                ex.getViolation());

        return ResponseEntity.status(status).body(body);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumenNotValid(MethodArgumentNotValidException ex) {
        List<FieldViolation> violations = ex.getBindingResult()
                .getFieldErrors().stream()
                .map(err -> new FieldViolation(
                        err.getField(),
                        err.getDefaultMessage(),
                        err.getRejectedValue()))
                .collect(Collectors.toList());

        var body = new ErrorResponse(
            Instant.now(),
            HttpStatus.BAD_REQUEST.value(), 
            HttpStatus.BAD_REQUEST.getReasonPhrase(), 
            "Datos invalidos", 
            violations);
        
        return ResponseEntity.badRequest().body(body);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrity(DataIntegrityViolationException ex){
        var status = HttpStatus.CONFLICT;
        var body = new ErrorResponse(
            Instant.now(),
            status.value(), 
            status.getReasonPhrase(), 
            "Violacion de integridad de datos", 
            List.of());

        return ResponseEntity.status(status).body(body);    
    }
}
