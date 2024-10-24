package com.meatplace.meatplace.controladores;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.meatplace.meatplace.repositorio.DisponibilidadMesaRepository;

@Controller
public class DisponibilidadMesaController {

    @Autowired
    private DisponibilidadMesaRepository disponibilidadMesaRepository;
    
    @PostMapping("/disponibilidad")
    @Transactional(readOnly = false)
    public String consultarDisponibilidad(@RequestParam("fecha") String fechaStr,
                                          @RequestParam("hora") String horaStr,
                                          Model model) {
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaLocal = LocalDate.parse(fechaStr, dateFormatter);
            Date fecha = Date.valueOf(fechaLocal);
    
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime horaLocal = LocalTime.parse(horaStr, timeFormatter);
            Time hora = Time.valueOf(horaLocal);
    
            if (hora != null) {
                model.addAttribute("formulario", 1);
            }
    
            List<Object[]> disponibilidad = disponibilidadMesaRepository.buscarDisponibilidad(fecha, hora);
            
            model.addAttribute("disponibilidadMesas", disponibilidad);
    
        } catch (DateTimeParseException e) {
            model.addAttribute("error", "Formato de fecha u hora inválido");
            return "reserva";
        }
    
        return "reserva";
    }
    


}
