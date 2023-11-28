package com.msvc.accountant.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Accountant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String dni;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    private String address;

    private String phone;

    @Column(name = "create_on", updatable = false)
    private LocalDateTime createOn;

    @Column(name = "update_on")
    private LocalDateTime updateOn;

    public boolean valid() {
        return isStringValid(dni)
                || isStringValid(firstName)
                || isEmailValid(email);
    }

    private boolean isStringValid(String value) {
        return value != null && value.isEmpty();
    }

    private boolean isEmailValid(String email) {
        if (isStringValid(email)) {
            return email.matches("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w+$");
        }
        return false;
    }
}
