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
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "TB_Reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreserva")
    private int idReserva;

    @Basic(optional = false)
    @Column(name = "numeropersonas")
    private int numeroPersonas;

    @Basic(optional = false)
    @Column(name = "fecha")
    private Date fecha;

    @Basic(optional = false)
    @Column(name = "horainicio")
    private Time horaInicio;

    @Basic(optional = false)
    @Column(name = "horafin")
    private Time horaFin;

    @Basic(optional = false)
    @Column(name = "comentarios")
    private String comentarios;

    @ManyToOne
    @JoinColumn(name = "idmesa", nullable = false)
    private Mesa idmesa; 

    @Column(name = "nombrecliente")
    private String nombreCliente;

    @Column(name = "apellidocliente")
    private String apellidoCliente;

    @Column(name = "telefonocliente")
    private String telefonoCliente;

    @Column(name = "correocliente")
    private String correoCliente;

    @Column(name = "dnicliente")
    private String dniCliente;

    

    public Reserva() {
    }

    public Reserva(int idReserva, int numeroPersonas, Date fecha, Time horaInicio, Time horaFin, String comentarios,
            Mesa mesa, String nombreCliente, String apellidoCliente, String telefonoCliente, String correoCliente,
            String dniCliente) {
        this.idReserva = idReserva;
        this.numeroPersonas = numeroPersonas;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.comentarios = comentarios;
        this.idmesa = mesa;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.telefonoCliente = telefonoCliente;
        this.correoCliente = correoCliente;
        this.dniCliente = dniCliente;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Mesa getMesa() {
        return idmesa;
    }

    public void setMesa(Mesa mesa) {
        this.idmesa = mesa;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }
}
