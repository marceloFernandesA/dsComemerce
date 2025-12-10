package com.marceloscorporation.dscommerce.controllers.handlers;

import com.marceloscorporation.dscommerce.dto.CustomErrorDTO;
import com.marceloscorporation.dscommerce.dto.ValidationErrorDTO;
import com.marceloscorporation.dscommerce.services.execeptions.DataBaseException;
import com.marceloscorporation.dscommerce.services.execeptions.ForbiddenException;
import com.marceloscorporation.dscommerce.services.execeptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

    @ControllerAdvice
    public class ControllerExceptionHandler {

        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<CustomErrorDTO> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
            HttpStatus status = HttpStatus.NOT_FOUND;
            CustomErrorDTO err = new CustomErrorDTO(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
            return ResponseEntity.status(status).body(err);
        }

        @ExceptionHandler(DataBaseException.class)
        public ResponseEntity<CustomErrorDTO> dataBase(ResourceNotFoundException e, HttpServletRequest request) {
            HttpStatus status = HttpStatus.BAD_REQUEST;
            CustomErrorDTO err = new CustomErrorDTO(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
            return ResponseEntity.status(status).body(err);
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<CustomErrorDTO> methodArgumentNotValidation(MethodArgumentNotValidException e, HttpServletRequest request) {
            HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
            ValidationErrorDTO err = new ValidationErrorDTO(Instant.now(), status.value(), "Dados inválidos", request.getRequestURI());
            for (FieldError f : e.getBindingResult().getFieldErrors()){
                err.addError(f.getField(),f.getDefaultMessage());
            }
            return ResponseEntity.status(status).body(err);

        }

        @ExceptionHandler(ForbiddenException.class)
        public ResponseEntity<CustomErrorDTO> forbidden(ForbiddenException e, HttpServletRequest request) {
            HttpStatus status = HttpStatus.FORBIDDEN;
            CustomErrorDTO err = new CustomErrorDTO(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
            return ResponseEntity.status(status).body(err);
        }
    }

