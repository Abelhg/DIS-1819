package es.uva.eii.ds.empresaX.negocio.modelos;

/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class EstadoPedido {

    private TipoEstadoPedido tipo;
    
    public EstadoPedido(TipoEstadoPedido tipo){
        this.tipo = tipo;
    }

    public TipoEstadoPedido getTipo() {
        return tipo;
    }

    public void setTipo(TipoEstadoPedido tipo) {
        this.tipo = tipo;
    }
    
}
