package es.uva.eii.ds.empresaX.interfaz.pares_vista_control.empleado;

/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class CtrlVistaIdentificarse {
    private VistaIdentificarse vista;
    
    // MENSAJES DE ERROR
    private static final String ERROR_CAMPOS_VACIOS = "No puede haber campos vacíos";
    
    public CtrlVistaIdentificarse(VistaIdentificarse vista) {
        this.vista = vista;
        vista.borrarMensajeError();
    }
    
    /**
     * Procesa la petición de conexión de un usuario.
     */
    public void procesaLogin() {
        vista.borrarMensajeError();
        
        // Obtiene los datos introducidos y comprueba no vacío
        String dni  = vista.getDNI();
        String pass = vista.getPassword();
        if(dni == null  || dni.isEmpty() || pass == null || pass.isEmpty()) {
            // Muestra mensaje de error correspondiente
            vista.mostrarMensajeError(ERROR_CAMPOS_VACIOS);
            return;
        }
        
        // Llamada identificarEmpleado(dni, pass) a ControladorCUIdentificarse
        // Decidir qué retorna
        
        // Si empleado identificado, llamar al GestorDeInterfaz
    }
}
