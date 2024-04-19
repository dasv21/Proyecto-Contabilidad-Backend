package com.msvc.authentication.controller;

import com.msvc.authentication.dto.ErrorDTO;
import com.msvc.authentication.exception.RequestValidateException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = RequestValidateException.class)
    public ResponseEntity<ErrorDTO> requestValidateExceptionHandler(RequestValidateException exception) {

        String exceptionName = exception.toString();

        ErrorDTO error = ErrorDTO.builder()
                .timestamp(LocalDateTime.now())
                .name(exceptionName)
                .code(exception.getStatus().value())
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(error, exception.getStatus());
    }
}
