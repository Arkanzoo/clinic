package com.example.clinic.model;

import lombok.Getter;

@Getter
public class User {

    // Getters e Setters
    private Long id;
    private String name;
    private String password;
    private String role;

    // Construtor padrão
    public User() {
    }

    // Construtor com parâmetros
    public User(Long id, String name, String password, String role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }
}