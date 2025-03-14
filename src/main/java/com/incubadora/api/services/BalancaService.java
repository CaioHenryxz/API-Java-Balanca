package com.incubadora.api.services;

import com.incubadora.api.models.Balanca;
import com.incubadora.api.repositories.BalancaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalancaService {

    @Autowired
    private BalancaRepository balancaRepository;

    @Autowired
    private LogBalancaService logBalancaService; 

    public List<Balanca> listarTodas() {
        return balancaRepository.findAll();
    }

    public Optional<Balanca> buscarPorId(Integer id) {
        return balancaRepository.findById(id);
    }

    public Balanca salvar(Balanca balanca) {
        
        if (balanca.getIdBalanca() == null) {
            return balancaRepository.save(balanca);
        }
    
        
        Optional<Balanca> balancaExistente = balancaRepository.findById(balanca.getIdBalanca());
        if (balancaExistente.isPresent()) {
            Integer estadoAnterior = balancaExistente.get().getEstadoBalanca();
            Integer novoEstado = balanca.getEstadoBalanca();
            if (!estadoAnterior.equals(novoEstado)) {
                logBalancaService.registrarLogBalanca(balanca.getIdBalanca(), estadoAnterior, novoEstado);
            }
        }
    
        return balancaRepository.save(balanca);
    }
    
    

    public void deletar(Integer id) {
        balancaRepository.deleteById(id);
    }
}
