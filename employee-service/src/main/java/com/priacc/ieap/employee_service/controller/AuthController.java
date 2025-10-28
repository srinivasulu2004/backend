package com.priacc.ieap.employee_service.controller;

import com.priacc.ieap.employee_service.dto.AuthRequest;
import com.priacc.ieap.employee_service.dto.AuthResponse;
import com.priacc.ieap.employee_service.entity.AppUser;
import com.priacc.ieap.employee_service.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest req) {
        String token = authService.registerUser(req.getUsername(), req.getPassword(), "HR");
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest req) {
        return authService.loginUser(req.getUsername(), req.getPassword())
                .map(token -> ResponseEntity.ok(new AuthResponse(token)))
                .orElseGet(() -> ResponseEntity.status(401).body(new AuthResponse("Invalid credentials")));
    }
}