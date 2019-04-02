package es.uva.eii.ds.empresaX.negocio.modelos;

/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class Disponibilidad {
    
    private TipoDisponibilidad tipo;

    public Disponibilidad(TipoDisponibilidad tipo) {
        this.tipo = tipo;
    }

    public TipoDisponibilidad getTipo() {
        return tipo;
    }

    public void setTipo(TipoDisponibilidad tipo) {
        this.tipo = tipo;
    }
    
    public boolean estaEnActivo(){
        boolean activo = false;
        
        switch(tipo) {
            case TRABAJANDO:
                activo = true;
                break;
            case BAJATEMPORAL:
            case VACACIONES:
            default:
                activo = false;
                break;
        }
        
        return activo;
    }
    
}
