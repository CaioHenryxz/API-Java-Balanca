package com.incubadora.api.controllers;

import com.incubadora.api.models.LogPaciente;
import com.incubadora.api.services.LogPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/log-pacientes")
public class LogPacienteController {

    @Autowired
    private LogPacienteService logPacienteService;

    @GetMapping
    public List<LogPaciente> listarTodos() {
        return logPacienteService.listarTodos();
    }

    @PostMapping
    public LogPaciente salvar(@RequestBody LogPaciente logPaciente) {
        return logPacienteService.salvar(logPaciente);
    }
}
