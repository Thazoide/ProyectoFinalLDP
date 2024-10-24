package com.meatplace.meatplace.repositorio;

import java.sql.Date;
import java.sql.Time;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.meatplace.meatplace.entidades.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
    
@Procedure(name = "InsertarReserva")
void insertarReserva(@Param("p_numeroPersonas")int numeroPersonas, @Param("p_fecha")Date fecha, @Param("p_horaInicio")Time horaInicio, @Param("p_comentarios")String comentarios, @Param("p_idmesa")int idMesa, @Param("p_nombrecliente")String nombreCliente, @Param("p_apellidocliente")String apellidoCliente, @Param("p_telefonocliente")String telefonocliente, @Param("p_correocliente")String correoCliente, @Param("p_dnicliente")String dniCliente);

@Query(value = "CALL ObtenerUltimaReserva()", nativeQuery = true)
Reserva obtenerUltimaReserva();

}
