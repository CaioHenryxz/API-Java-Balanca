package com.incubadora.api.services;

import com.incubadora.api.models.LogPaciente;
import com.incubadora.api.models.Paciente;
import com.incubadora.api.models.Balanca;
import com.incubadora.api.repositories.LogPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogPacienteService {

    @Autowired
    private LogPacienteRepository logPacienteRepository;

    public List<LogPaciente> listarTodos() {
        return logPacienteRepository.findAll();
    }

    public LogPaciente salvar(LogPaciente logPaciente) {
        return logPacienteRepository.save(logPaciente);
    }

    public void registrarLogPaciente(Integer idPaciente, Integer idBalancaAnterior, Integer idBalancaNova) {
        LogPaciente log = new LogPaciente();
        log.setDataLog(LocalDateTime.now());
        log.setPaciente(new Paciente());
        log.getPaciente().setIdPaciente(idPaciente);
        log.setBalanca(new Balanca());
        log.getBalanca().setIdBalanca(idBalancaAnterior);
        log.setNovoIdBalanca(idBalancaNova);

        logPacienteRepository.save(log);
    }
}
