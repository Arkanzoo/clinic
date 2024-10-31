package com.example.clinic.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String operation; // "INSERT", "UPDATE", "DELETE"
    private LocalDateTime timestamp;

    private Long entityId;    // ID da entidade `Consulta` modificada

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Usuário que realizou a operação
}