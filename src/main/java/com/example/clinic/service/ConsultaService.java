package com.example.clinic.service;

import com.example.clinic.model.Audit;
import com.example.clinic.model.Consulta;
import com.example.clinic.model.User;
import com.example.clinic.repository.AuditRepository;
import com.example.clinic.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private AuditRepository auditRepository;

    public List<Consulta> findAll() {
        return consultaRepository.findAll();
    }

    public Consulta findById(Long id) {
        return consultaRepository.findById(id).orElse(null);
    }

    public Consulta save(Consulta consulta, User user) {
        Consulta savedConsulta = consultaRepository.save(consulta);
        audit("INSERT", savedConsulta.getId(), user);
        return savedConsulta;
    }

    public Consulta update(Consulta consulta, User user) {
        Consulta updatedConsulta = consultaRepository.save(consulta);
        audit("UPDATE", updatedConsulta.getId(), user);
        return updatedConsulta;
    }

    public void deleteById(Long id, User user) {
        consultaRepository.deleteById(id);
        audit("DELETE", id, user);
    }

    private void audit(String operation, Long entityId, User user) {
        Audit audit = new Audit();
        audit.setOperation(operation);
        audit.setTimestamp(LocalDateTime.now());
        audit.setEntityId(entityId);
        audit.setUser(user);
        auditRepository.save(audit);
    }
}