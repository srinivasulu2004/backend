package com.priacc.ieap.employee_service.service;

import com.priacc.ieap.employee_service.repository.AppUserRepository;
import com.priacc.ieap.employee_service.entity.AppUser;
import com.priacc.ieap.employee_service.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AppUserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String registerUser(String username, String password, String role) {
        AppUser user = AppUser.builder()
                .username(username)
                .passwordHash(passwordEncoder.encode(password))
                .role(role)
                .build();
        userRepository.save(user);
        return jwtUtil.generateToken(username, role);
    }

    public Optional<String> loginUser(String username, String password) {
        return userRepository.findByUsername(username)
                .filter(user -> passwordEncoder.matches(password, user.getPasswordHash()))
                .map(user -> jwtUtil.generateToken(user.getUsername(), user.getRole()));
    }
}