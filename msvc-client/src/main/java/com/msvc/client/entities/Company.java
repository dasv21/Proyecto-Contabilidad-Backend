package com.msvc.client.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String rif;

    @Column(name = "short_name", nullable = false)
    private String shortName;

    @Column(name = "legal_name", nullable = false)
    private String legalName;

    @Column(unique = true, nullable = false)
    private String email;

    private List<String> phones;

    private String address;

    private String accountant;

    @Column(name = "create_on", updatable = false)
    private LocalDateTime createOn;

    @Column(name = "update_on")
    private LocalDateTime updateOn;

    public boolean valid() {
        return isStringValid(rif)
                || isStringValid(shortName)
                || isStringValid(legalName)
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
