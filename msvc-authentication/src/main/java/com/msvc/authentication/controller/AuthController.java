package com.msvc.authentication.controller;

import com.msvc.authentication.request.*;
import com.msvc.authentication.response.AuthResponse;
import com.msvc.authentication.response.UserResponse;
import com.msvc.authentication.response.ValidateTokenResponse;
import com.msvc.authentication.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author David Santiago
 */
@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/open/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {

        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {

        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/open/validate-token")
    public ResponseEntity<ValidateTokenResponse> validateToken(@RequestBody ValidateTokenRequest request) {
        boolean isValid = authService.validateToken(request.getToken());
        ValidateTokenResponse response = new ValidateTokenResponse(isValid);
        return isValid ? ResponseEntity.ok(response) : ResponseEntity.status(401).body(response);
    }

    @PutMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequest request) {
        authService.changePassword(request);
        return ResponseEntity.ok("Password changed successfully");
    }

    @PutMapping("/change-role")
    public ResponseEntity<?> changeRole(@RequestBody ChangeRoleRequest request) {
        authService.changeRole(request);
        return ResponseEntity.ok("Role changed successfully");
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> listUsers() {
        List<UserResponse> users = authService.listUsers();
        return ResponseEntity.ok(users);
    }
}
