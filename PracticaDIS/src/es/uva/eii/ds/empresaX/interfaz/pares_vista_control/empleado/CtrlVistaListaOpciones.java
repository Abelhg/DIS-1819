package es.uva.eii.ds.empresaX.interfaz.pares_vista_control.empleado;

/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class CtrlVistaListaOpciones {
    
    private final VistaListaOpciones vista;
    
    public CtrlVistaListaOpciones(VistaListaOpciones v) {
        vista = v;
        // Centra en la pantalla
        vista.setLocationRelativeTo(null);
    }
    
    
    
}
