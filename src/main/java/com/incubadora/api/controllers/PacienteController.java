package com.incubadora.api.controllers;

import com.incubadora.api.models.Paciente;
import com.incubadora.api.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> listarTodos() {
        return pacienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Integer id) {
        Optional<Paciente> paciente = pacienteService.buscarPorId(id);
        return paciente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Paciente salvar(@RequestBody Paciente paciente) {
        return pacienteService.salvar(paciente, null);
    }

    @PutMapping("/{id}") 
    public ResponseEntity<Paciente> atualizarPaciente(@PathVariable Integer id, @RequestBody PacienteRequest request) {
        Optional<Paciente> pacienteOptional = pacienteService.buscarPorId(id);
        if (pacienteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Paciente paciente = pacienteOptional.get();
        paciente.setHashPaciente(request.getHashPaciente());

        Paciente pacienteAtualizado = pacienteService.salvar(paciente, request.getIdBalancaNova());
        return ResponseEntity.ok(pacienteAtualizado);
    }

    public static class PacienteRequest {
        private String hashPaciente;
        private Integer idBalancaNova;

        public String getHashPaciente() {
            return hashPaciente;
        }

        public void setHashPaciente(String hashPaciente) {
            this.hashPaciente = hashPaciente;
        }

        public Integer getIdBalancaNova() {
            return idBalancaNova;
        }

        public void setIdBalancaNova(Integer idBalancaNova) {
            this.idBalancaNova = idBalancaNova;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        pacienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
