package com.meatplace.meatplace.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meatplace.meatplace.entidades.Mesa;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Integer> {
    // Métodos personalizados si es necesario
}