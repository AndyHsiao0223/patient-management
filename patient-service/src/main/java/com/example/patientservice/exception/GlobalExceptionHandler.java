package com.example.patientservice.exception;

import com.example.patientservice.dto.ValidationErrorResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponseDTO> handleValidationException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();

        ValidationErrorResponseDTO errorResponse = new ValidationErrorResponseDTO(
                "VALIDATION_ERROR",
                fieldError != null ? fieldError.getDefaultMessage() : "Validation failed"
        );

        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ValidationErrorResponseDTO> handleEmailAlreadyExistsException(EmailAlreadyExistsException ex) {
        log.warn("Email already exists: {}", ex.getMessage());

        ValidationErrorResponseDTO errorResponse = new ValidationErrorResponseDTO(
                "EMAIL_ALREADY_EXISTS",
                ex.getMessage()
        );

        return ResponseEntity.badRequest().body(errorResponse);
    }
}
