/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.ds.empresaX.negocio.modelos;

import java.time.LocalDate;
import java.util.Date;
import java.util.TreeMap;

/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class PedidoDeHorno {
    private int numeroDePedido;
    private Date fechaEnLaQueSeQuiere;
    private Cliente cliente;
    private Empleado dependiente;
    private TreeMap<LocalDate, EstadoPedido> estadoPedido;

    public PedidoDeHorno(int numeroDePedido, Date fechaEnLaQueSeQuiere, Cliente cliente, Empleado dependiente) {
        this.numeroDePedido = numeroDePedido;
        this.fechaEnLaQueSeQuiere = fechaEnLaQueSeQuiere;
        this.cliente = cliente;
        this.dependiente = dependiente;
    }

    public int getNumeroDePedido() {
        return numeroDePedido;
    }

    public void setNumeroDePedido(int numeroDePedido) {
        this.numeroDePedido = numeroDePedido;
    }

    public Date getFechaEnLaQueSeQuiere() {
        return fechaEnLaQueSeQuiere;
    }

    public void setFechaEnLaQueSeQuiere(Date fechaEnLaQueSeQuiere) {
        this.fechaEnLaQueSeQuiere = fechaEnLaQueSeQuiere;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getDependiente() {
        return dependiente;
    }

    public void setDependiente(Empleado dependiente) {
        this.dependiente = dependiente;
    }

    public EstadoPedido getUltimoEstado() {
        return estadoPedido.lastEntry().getValue();
    }

    public void setEstadoPedido(TreeMap<LocalDate, EstadoPedido> estadoPedido) {
        this.estadoPedido = estadoPedido;
    }
    
}
