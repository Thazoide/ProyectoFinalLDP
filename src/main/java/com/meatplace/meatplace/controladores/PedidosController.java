package com.meatplace.meatplace.controladores;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.meatplace.meatplace.entidades.Mesa;
import com.meatplace.meatplace.entidades.Pedido;
import com.meatplace.meatplace.entidades.Plato;
import com.meatplace.meatplace.repositorio.MesaRepository;
import com.meatplace.meatplace.repositorio.PedidoRepository;
import com.meatplace.meatplace.repositorio.PlatoRepository;
import com.meatplace.meatplace.services.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidosController {

	@Autowired
	private PlatoRepository platoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private MesaRepository mesaRepository;

    @Autowired
    private PedidoService pedidoService;


	@GetMapping("/nuevo")
	public String mostrarFormularioDePedido(Model model) {
		List<Plato> platos = platoRepository.findAll();
		model.addAttribute("platos", platos);
		return "pedido"; 
	}


	@PostMapping("/nuevo")
	public String procesarPedido(@RequestParam List<Long> platosSeleccionados,
	                             @RequestParam int idMesa,
	                             @RequestParam String nombreCliente, 
	                             Model model) {
	    try {
	        if (platosSeleccionados.isEmpty()) {
	            model.addAttribute("error", "Debe seleccionar al menos un plato.");
	            return "pedido";
	        }

	        List<Plato> platos = obtenerPlatosSeleccionados(platosSeleccionados);
	        double total = calcularTotal(platos);

	        Mesa mesa = mesaRepository.findById(idMesa)
	                                   .orElseThrow(() -> new IllegalArgumentException("Mesa no encontrada"));

	        Pedido pedido = new Pedido();
	        pedido.setMesa(mesa);
	        pedido.setTotal(total);
	        pedido.setPlatos(platos);
	        pedido.setCliente(nombreCliente); 

	        pedidoRepository.save(pedido);
	        
	        model.addAttribute("pedido", pedido);

	        model.addAttribute("pedido", pedido); 
	        model.addAttribute("idMesa", idMesa);
	        model.addAttribute("platos", platos);
	        model.addAttribute("total", total);
	        model.addAttribute("cliente", nombreCliente);

	        return "confirmacion";
	    } catch (Exception e) {
	        model.addAttribute("error", "Error al procesar el pedido: " + e.getMessage());
	        return "pedido";
	    }
	}



	private List<Plato> obtenerPlatosSeleccionados(List<Long> ids) {
		return platoRepository.findAllById(ids);
	}


	private double calcularTotal(List<Plato> platos) {
		return platos.stream().mapToDouble(Plato::getPrecio).sum();
	}

    @GetMapping("/todos")
public String mostrarPedidos(Model model) {
    List<Pedido> pedidos = pedidoService.obtenerTodos();
    
    pedidos = pedidos.stream()
                     .filter(pedido -> pedido != null)
                     .collect(Collectors.toList());
    
    long totalEntregados = pedidos.stream()
                                   .filter(p -> "Entregado".equals(p.getEstado()))
                                   .count();
    long totalPendientes = pedidos.size() - totalEntregados;
    
    model.addAttribute("pedidos", pedidos);
    model.addAttribute("totalEntregados", totalEntregados);
    model.addAttribute("totalPendientes", totalPendientes);
    
    return "gestion-pedidos"; // Nombre de tu vista (HTML)
}
    @PostMapping("/actualizarEstado")
    public String actualizarEstado(@RequestParam Long idPedido, @RequestParam String nuevoEstado) {
        pedidoService.actualizarEstado(idPedido, nuevoEstado);
        return "redirect:/pedidos/todos";
    }

    @GetMapping("/confirmacion/{pedidoId}")
    public String mostrarConfirmacionPedido(@PathVariable Long pedidoId, Model model) {
    Pedido pedido = pedidoRepository.findById(pedidoId)
            .orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado"));

    model.addAttribute("pedido", pedido);
    return "confirmacion"; 
}


}