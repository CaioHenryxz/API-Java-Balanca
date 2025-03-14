package com.incubadora.api.repositories;

import com.incubadora.api.models.LogPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface LogPacienteRepository extends JpaRepository<LogPaciente, Integer> {
    Optional<LogPaciente> findTopByPacienteIdPacienteOrderByDataLogDesc(Integer idPaciente);
}
