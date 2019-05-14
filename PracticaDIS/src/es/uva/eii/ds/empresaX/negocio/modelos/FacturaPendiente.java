package es.uva.eii.ds.empresaX.negocio.modelos;

import java.time.LocalDate;

public final class FacturaPendiente {
    private final String nombreProveedor;
    private final long numeroPedido;
    private final double importe;
    private final LocalDate fechaPedido;
    private final LocalDate fechaEmision;

    public FacturaPendiente(String nombreProveedor, long numeroPedido, double importe, LocalDate fechaPedido, LocalDate fechaEmision) {
        this.nombreProveedor = nombreProveedor;
        this.numeroPedido = numeroPedido;
        this.importe = importe;
        this.fechaPedido = fechaPedido;
        this.fechaEmision = fechaEmision;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public long getNumeroPedido() {
        return numeroPedido;
    }

    public double getImporte() {
        return importe;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }
    
}
