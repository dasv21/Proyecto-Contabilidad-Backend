package com.msvc.accountant.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * @author David Santiago
 */
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
