package com.msvc.authentication.services;

import com.msvc.authentication.entities.Role;
import com.msvc.authentication.entities.UserCredential;
import com.msvc.authentication.repository.UserRepository;
import com.msvc.authentication.request.ChangePasswordRequest;
import com.msvc.authentication.request.ChangeRoleRequest;
import com.msvc.authentication.request.LoginRequest;
import com.msvc.authentication.request.RegisterRequest;
import com.msvc.authentication.response.AuthResponse;
import com.msvc.authentication.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for authentication and user management.
 * @author David Santiago
 */
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        UserCredential user = UserCredential.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }

    @Transactional
    public void changePassword(ChangePasswordRequest request) {
        UserCredential user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);
    }

    @Transactional
    public void changeRole(ChangeRoleRequest request) {
        UserCredential user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setRole(Role.valueOf(request.getNewRole().toUpperCase()));
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public List<UserResponse> listUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserResponse(user.getUsername(), user.getRole().name()))
                .collect(Collectors.toList());
    }

    public boolean validateToken(String token) {
        return jwtService.isTokenValid(token, getUserDetailsFromToken(token));
    }

    private UserDetails getUserDetailsFromToken(String token) {
        String username = jwtService.getUsernameFromToken(token);
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User Failed"));
    }
}
