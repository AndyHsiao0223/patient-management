package com.example.patientservice.exception;

import com.example.patientservice.dto.ValidationErrorResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponseDTO> handleValidationException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();

        ValidationErrorResponseDTO errorResponse = new ValidationErrorResponseDTO(
                "VALIDATION_ERROR",
                fieldError != null ? fieldError.getDefaultMessage() : "Validation failed"
        );

        return ResponseEntity.badRequest().body(errorResponse);
    }
}
