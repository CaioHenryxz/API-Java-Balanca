package com.incubadora.api.repositories;

import com.incubadora.api.models.LogBalanca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogBalancaRepository extends JpaRepository<LogBalanca, Integer> {
}
