package com.msvc.bill.controller;

import com.msvc.bill.dto.ErrorDTO;
import com.msvc.bill.exception.RequestValidateException;
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