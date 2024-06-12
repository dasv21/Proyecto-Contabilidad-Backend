package com.msvc.authentication.repository;

import com.msvc.authentication.entities.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author David Santiago
 */
public interface UserRepository extends JpaRepository<UserCredential, Long> {
    Optional<UserCredential> findByUsername(String username);
}
