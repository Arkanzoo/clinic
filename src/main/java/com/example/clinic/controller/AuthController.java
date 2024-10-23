package com.example.clinic.controller;

import com.example.clinic.dto.AuthRequest;
import com.example.clinic.model.User;
import com.example.clinic.security.JwtTokenUtil;
import com.example.clinic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        Optional<User> user = userService.getUserByName(authRequest.getUsername());

        if (user.isPresent() && user.get().getPassword().equals(authRequest.getPassword())) {
            String token = jwtTokenUtil.generateToken(user.get());
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
    }
}