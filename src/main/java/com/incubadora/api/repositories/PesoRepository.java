package com.incubadora.api.repositories;

import com.incubadora.api.models.Peso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PesoRepository extends JpaRepository<Peso, Integer> {
}
