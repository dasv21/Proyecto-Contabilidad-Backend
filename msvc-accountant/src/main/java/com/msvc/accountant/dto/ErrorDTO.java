package com.msvc.accountant.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author David Santiago
 */
@Data
@Builder
public class ErrorDTO {

    private LocalDateTime timestamp;

    private String name;

    private int code;

    private String message;
}
