package com.incubadora.api.controllers;

import com.incubadora.api.models.LogBalanca;
import com.incubadora.api.services.LogBalancaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/log-balancas")
public class LogBalancaController {

    @Autowired
    private LogBalancaService logBalancaService;

    @GetMapping
    public List<LogBalanca> listarTodos() {
        return logBalancaService.listarTodos();
    }

    @PostMapping
    public LogBalanca salvar(@RequestBody LogBalanca logBalanca) {
        return logBalancaService.salvar(logBalanca);
    }
}
