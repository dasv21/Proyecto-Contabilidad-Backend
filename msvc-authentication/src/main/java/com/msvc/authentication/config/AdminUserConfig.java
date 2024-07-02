package com.msvc.authentication.config;

import com.msvc.authentication.entities.Role;
import com.msvc.authentication.entities.UserCredential;
import com.msvc.authentication.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author David Santiago
 */
@Configuration
public class AdminUserConfig {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                UserCredential admin = UserCredential.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("dasv21"))
                        .email("admin@admin.com")
                        .role(Role.ADMIN)
                        .build();

                userRepository.save(admin);
            }
        };
    }
}

