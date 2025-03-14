package com.incubadora.api.services;

import com.incubadora.api.models.Balanca;
import com.incubadora.api.models.Paciente;
import com.incubadora.api.models.Peso;
import com.incubadora.api.repositories.BalancaRepository;
import com.incubadora.api.repositories.PacienteRepository;
import com.incubadora.api.repositories.PesoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PesoService {

    @Autowired
    private PesoRepository pesoRepository;

    @Autowired
    private BalancaRepository balancaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Peso> listarTodos() {
        return pesoRepository.findAll();
    }

    public Peso salvar(Peso peso, Integer idBalanca, Integer idPaciente) {
        
        Optional<Balanca> balancaOpt = balancaRepository.findById(idBalanca);
        if (balancaOpt.isEmpty()) {
            throw new RuntimeException("Balança não encontrada!");
        }

        
        Optional<Paciente> pacienteOpt = pacienteRepository.findById(idPaciente);
        if (pacienteOpt.isEmpty()) {
            throw new RuntimeException("Paciente não encontrado!");
        }

        
        peso.setBalanca(balancaOpt.get());
        peso.setPaciente(pacienteOpt.get());

        return pesoRepository.save(peso);
    }
}
