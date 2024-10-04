package com.example.clinic.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    @Embedded
    private Endereco endereco;
}
