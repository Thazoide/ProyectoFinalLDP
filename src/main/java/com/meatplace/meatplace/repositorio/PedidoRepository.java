package com.meatplace.meatplace.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.meatplace.meatplace.entidades.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("SELECT p.nombre, pp.pedidoId, pp.platoId FROM PedidoPlato pp JOIN Plato p ON pp.platoId = p.id WHERE pp.pedidoId = :pedidoId")
    List<Object[]> obtenerDetallePedido(@Param("pedidoId") Long pedidoId);
}
