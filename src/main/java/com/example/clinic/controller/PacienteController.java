package com.example.clinic.controller;

import com.example.clinic.model.Paciente;
import com.example.clinic.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> getAll() {
        return pacienteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getById(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.findById(id));
    }

    @PostMapping
    public Paciente create(@RequestBody Paciente paciente) {
        return pacienteService.save(paciente);
    }

    @PutMapping("/{id}")
    public Paciente update(@PathVariable Long id, @RequestBody Paciente paciente) {
        Paciente existing = pacienteService.findById(id);
        existing.setNome(paciente.getNome());
        existing.setCpf(paciente.getCpf());
        existing.setEmail(paciente.getEmail());
        existing.setTelefone(paciente.getTelefone());
        existing.setEndereco(paciente.getEndereco());
        return pacienteService.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pacienteService.deleteById(id);
    }
}