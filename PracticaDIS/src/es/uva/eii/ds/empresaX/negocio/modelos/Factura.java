package es.uva.eii.ds.empresaX.negocio.modelos;

import java.time.LocalDate;

public final class Factura {
    private final LocalDate fechaEmision;
    private final double importe;
    private final String cuentaBancaria;

    public Factura(LocalDate fechaEmision, double importe, String cuentaBancaria) {
        this.fechaEmision = fechaEmision;
        this.importe = importe;
        this.cuentaBancaria = cuentaBancaria;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public double getImporte() {
        return importe;
    }

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }
    
}
