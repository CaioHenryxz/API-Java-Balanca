package com.incubadora.api.services;

import com.incubadora.api.models.Paciente;
import com.incubadora.api.models.Balanca;
import com.incubadora.api.models.LogPaciente;
import com.incubadora.api.repositories.PacienteRepository;
import com.incubadora.api.repositories.BalancaRepository;
import com.incubadora.api.repositories.LogPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private LogPacienteRepository logPacienteRepository;

    @Autowired
    private BalancaRepository balancaRepository;

    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> buscarPorId(Integer id) {
        return pacienteRepository.findById(id);
    }

    public Paciente salvar(Paciente paciente, Integer idBalancaNova) {
        
        if (paciente.getIdPaciente() != null) {
            Optional<Paciente> pacienteExistente = pacienteRepository.findById(paciente.getIdPaciente());
            if (pacienteExistente.isPresent()) {
                Integer idBalancaAnterior = buscarUltimaBalancaDoPaciente(paciente.getIdPaciente());
                
                if (idBalancaNova != null && !idBalancaNova.equals(idBalancaAnterior)) {
                    registrarLogPaciente(paciente.getIdPaciente(), idBalancaAnterior, idBalancaNova);
                }
            }
        }
        
        return pacienteRepository.save(paciente);
    }

    private Integer buscarUltimaBalancaDoPaciente(Integer idPaciente) {
        return logPacienteRepository.findTopByPacienteIdPacienteOrderByDataLogDesc(idPaciente)
                .map(LogPaciente::getNovoIdBalanca)
                .orElse(null);
    }

    private void registrarLogPaciente(Integer idPaciente, Integer idBalancaAnterior, Integer idBalancaNova) {
        LogPaciente log = new LogPaciente();
        log.setDataLog(java.time.LocalDateTime.now());

        
        Paciente paciente = pacienteRepository.findById(idPaciente)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        log.setPaciente(paciente);

        
        if (idBalancaAnterior != null && idBalancaAnterior > 0) {
            Optional<Balanca> optBalanca = balancaRepository.findById(idBalancaAnterior);
            if (optBalanca.isPresent()) {
                log.setBalanca(optBalanca.get());
            } else {
                
                System.err.println("Aviso: Balança com ID " + idBalancaAnterior + " não encontrada. Salvando log sem balança.");
                log.setBalanca(null);
            }
        } else {
            log.setBalanca(null);
        }

        log.setNovoIdBalanca(idBalancaNova);

        logPacienteRepository.save(log);
    }

    public void deletar(Integer id) {
        pacienteRepository.deleteById(id);
    }
}
