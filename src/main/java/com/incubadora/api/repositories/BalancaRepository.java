package com.incubadora.api.repositories;

import com.incubadora.api.models.Balanca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalancaRepository extends JpaRepository<Balanca, Integer> {
}
