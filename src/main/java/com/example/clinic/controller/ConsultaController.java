package com.example.clinic.controller;

import com.example.clinic.model.Consulta;
import com.example.clinic.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    public List<Consulta> getAll() {
        return consultaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> getById(@PathVariable Long id) {
        return ResponseEntity.ok(consultaService.findById(id));
    }

    @PostMapping
    public Consulta create(@RequestBody Consulta consulta) {
        return consultaService.save(consulta);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        consultaService.deleteById(id);
    }
}