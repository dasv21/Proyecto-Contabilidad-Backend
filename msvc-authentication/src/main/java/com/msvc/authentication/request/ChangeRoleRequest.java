package com.msvc.authentication.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author David Santiago
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChangeRoleRequest {
    private String username;
    private String newRole;
}