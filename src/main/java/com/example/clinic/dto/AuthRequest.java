package com.example.clinic.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthRequest {

    // Getters e Setters
    private String username;
    private String password;

    // Construtor padrão
    public AuthRequest() {
    }

    // Construtor com parâmetros
    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

}