package com.meatplace.meatplace.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Basic;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tb_disponibilidadmesas")
public class DisponibilidadMesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddisponibilidad")
    private int idDisponibilidad;


    @ManyToOne
    @JoinColumn(name = "idmesa", nullable = false)
    private Mesa mesa; 

    @Basic(optional = false)
    @Column(name = "fecha")
    private LocalDate fecha;

    @Basic(optional = false)
    @Column(name = "horainicio")
    private LocalTime horaInicio;

    @Basic(optional = false)
    @Column(name = "horafin")
    private LocalTime horaFin;

    @Basic(optional = false)
    @Column(name = "disponible")
    private boolean disponible;


    public DisponibilidadMesa(Mesa mesa, boolean disponible) {
        this.mesa = mesa;
        this.disponible = disponible;
    }

    public DisponibilidadMesa() {
    }

    public DisponibilidadMesa(int idDisponibilidad, Mesa mesa, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin,
            boolean disponible) {
        this.idDisponibilidad = idDisponibilidad;
        this.mesa = mesa;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.disponible = disponible;
    }

    public int getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(int idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }


    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
