package com.meatplace.meatplace.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meatplace.meatplace.entidades.Pedido;
import com.meatplace.meatplace.repositorio.PedidoRepository;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> obtenerTodos() {
        return pedidoRepository.findAll();
    }

    public void actualizarEstado(Long idPedido, String nuevoEstado) {
        Pedido pedido = pedidoRepository.findById(idPedido).orElseThrow();
        pedido.setEstado(nuevoEstado);
        pedidoRepository.save(pedido);
    }
}