package com.meatplace.meatplace.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meatplace.meatplace.entidades.Plato;

public interface PlatoRepository extends JpaRepository<Plato, Long> {
}