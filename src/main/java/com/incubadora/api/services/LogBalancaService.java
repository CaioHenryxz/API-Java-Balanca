package com.incubadora.api.services;

import com.incubadora.api.models.Balanca;
import com.incubadora.api.models.LogBalanca;
import com.incubadora.api.repositories.LogBalancaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogBalancaService {

    @Autowired
    private LogBalancaRepository logBalancaRepository;

    public List<LogBalanca> listarTodos() {
        return logBalancaRepository.findAll();
    }

    public LogBalanca salvar(LogBalanca logBalanca) {
        return logBalancaRepository.save(logBalanca);
    }

    public void registrarLogBalanca(Integer idBalanca, Integer estadoAnterior, Integer novoEstado) {
        LogBalanca log = new LogBalanca();
        log.setDataLog(LocalDateTime.now());

        
        Balanca balanca = new Balanca();
        balanca.setIdBalanca(idBalanca);
        log.setBalanca(balanca);

        log.setEstadoBalanca(estadoAnterior);
        log.setNovoEstadoBalanca(novoEstado);
        
        logBalancaRepository.save(log);
    }
}
