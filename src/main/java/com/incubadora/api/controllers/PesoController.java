package com.incubadora.api.controllers;

import com.incubadora.api.models.Peso;
import com.incubadora.api.services.PesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/pesos")
public class PesoController {

    @Autowired
    private PesoService pesoService;

    @GetMapping
    public List<Peso> listarTodos() {
        return pesoService.listarTodos();
    }

    @PostMapping
    public Peso salvar(@RequestBody PesoRequest request) {
        Peso peso = new Peso();

        // Converter a String "dataPeso" para LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime dataPesoFormatada = LocalDateTime.parse(request.getDataPeso(), formatter);

        peso.setDataPeso(dataPesoFormatada);
        peso.setPeso(request.getPeso());

        return pesoService.salvar(peso, request.getIdBalanca(), request.getIdPaciente());
    }

    public static class PesoRequest {
        private String dataPeso;
        private Integer idBalanca;
        private Integer idPaciente;
        private Integer peso;

        public String getDataPeso() {
            return dataPeso;
        }

        public void setDataPeso(String dataPeso) {
            this.dataPeso = dataPeso;
        }

        public Integer getIdBalanca() {
            return idBalanca;
        }

        public void setIdBalanca(Integer idBalanca) {
            this.idBalanca = idBalanca;
        }

        public Integer getIdPaciente() {
            return idPaciente;
        }

        public void setIdPaciente(Integer idPaciente) {
            this.idPaciente = idPaciente;
        }

        public Integer getPeso() {
            return peso;
        }

        public void setPeso(Integer peso) {
            this.peso = peso;
        }
    }
}
