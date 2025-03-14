package com.incubadora.api.controllers;

import com.incubadora.api.models.Balanca;
import com.incubadora.api.services.BalancaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/balancas")
public class BalancaController {

    @Autowired
    private BalancaService balancaService;

    @GetMapping
    public List<Balanca> listarTodas() {
        return balancaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Balanca> buscarPorId(@PathVariable Integer id) {
        Optional<Balanca> balanca = balancaService.buscarPorId(id);
        return balanca.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Balanca salvar(@RequestBody Balanca balanca) {
        return balancaService.salvar(balanca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        balancaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
