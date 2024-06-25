package com.msvc.authentication.controller;

import com.msvc.authentication.request.LoginRequest;
import com.msvc.authentication.request.RegisterRequest;
import com.msvc.authentication.request.ValidateTokenRequest;
import com.msvc.authentication.response.AuthResponse;
import com.msvc.authentication.response.ValidateTokenResponse;
import com.msvc.authentication.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author David Santiago
 */
@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {

        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {

        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("validate-token")
    public ResponseEntity<ValidateTokenResponse> validateToken(@RequestBody ValidateTokenRequest request) {
        boolean isValid = authService.validateToken(request.getToken());
        ValidateTokenResponse response = new ValidateTokenResponse(isValid);
        return isValid ? ResponseEntity.ok(response) : ResponseEntity.status(401).body(response);
    }
}
