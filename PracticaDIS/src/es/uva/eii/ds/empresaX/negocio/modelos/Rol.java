package es.uva.eii.ds.empresaX.negocio.modelos;

import java.time.LocalDate;

/**
 *
 * @author Zarkrosh
 */
public class Rol {

    private LocalDate comienzoEnRol;
    private TipoRol tipo;
    
    public Rol(LocalDate comienzoEnRol,TipoRol tipo){
        this.comienzoEnRol = comienzoEnRol;
        this.tipo = tipo;
    }

    public LocalDate getComienzoEnRol() {
        return comienzoEnRol;
    }

    public void setComienzoEnRol(LocalDate comienzoEnRol) {
        this.comienzoEnRol = comienzoEnRol;
    }

    public TipoRol getTipo() {
        return tipo;
    }

    public void setTipo(TipoRol tipo) {
        this.tipo = tipo;
    }
    
}
