package com.incubadora.api.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "balanca")
public class Balanca implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBalanca;

    @Column(nullable = false, length = 255)
    private String hashBalanca;

    @Column(nullable = false)
    private Integer estadoBalanca;

    public Integer getIdBalanca() {
        return idBalanca;
    }

    public void setIdBalanca(Integer idBalanca) {
        this.idBalanca = idBalanca;
    }

    public String getHashBalanca() {
        return hashBalanca;
    }

    public void setHashBalanca(String hashBalanca) {
        this.hashBalanca = hashBalanca;
    }

    public Integer getEstadoBalanca() {
        return estadoBalanca;
    }

    public void setEstadoBalanca(Integer estadoBalanca) {
        this.estadoBalanca = estadoBalanca;
    }
}
