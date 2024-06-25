package com.msvc.authentication.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author David Santiago
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidateTokenResponse {
    private boolean valid;
}
