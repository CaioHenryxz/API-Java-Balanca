package com.incubadora.api.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_paciente")
public class LogPaciente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLog;

    @Column(nullable = false)
    private LocalDateTime dataLog;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne(optional = true) 
    @JoinColumn(name = "id_balanca", nullable = true)
    private Balanca balanca;

    @Column(nullable = false)
    private Integer novoIdBalanca;

    public Integer getIdLog() {
        return idLog;
    }

    public void setIdLog(Integer idLog) {
        this.idLog = idLog;
    }

    public LocalDateTime getDataLog() {
        return dataLog;
    }

    public void setDataLog(LocalDateTime dataLog) {
        this.dataLog = dataLog;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Balanca getBalanca() {
        return balanca;
    }

    public void setBalanca(Balanca balanca) {
        this.balanca = balanca;
    }

    public Integer getNovoIdBalanca() {
        return novoIdBalanca;
    }

    public void setNovoIdBalanca(Integer novoIdBalanca) {
        this.novoIdBalanca = novoIdBalanca;
    }
}
