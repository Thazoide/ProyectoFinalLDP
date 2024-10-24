package com.meatplace.meatplace.repositorio;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.meatplace.meatplace.entidades.DisponibilidadMesa;

@Repository
public interface DisponibilidadMesaRepository extends JpaRepository<DisponibilidadMesa, Integer> {

    @Procedure(name = "BuscarDisponibilidad")
    List<Object[]> buscarDisponibilidad(@Param("p_fecha") Date fecha, @Param("p_hora") Time hora);

}