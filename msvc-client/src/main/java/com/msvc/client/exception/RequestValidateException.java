package com.msvc.client.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
public class RequestValidateException extends RuntimeException {

    private HttpStatus status;

    public RequestValidateException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
