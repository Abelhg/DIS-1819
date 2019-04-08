package es.uva.eii.ds.empresaX.interfaz.pares_vista_control.empleado;

import es.uva.eii.ds.empresaX.negocio.controladoresCasoUso.ControladorCUIdentificarse;

/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class CtrlVistaIdentificarse {
    
    private final VistaIdentificarse vista;
    
    // MENSAJES DE ERROR
    public static final String ERROR_CAMPOS_VACIOS = "No puede haber campos vacíos";
    public static final String ERROR_PASS_INCORRECTA = "Contraseña incorrecta";
    public static final String ERROR_DNI_NO_EXISTENTE = "DNI no existente";
    public static final String ERROR_INESPERADO = "Error inesperado";
    
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
        if(noVacia(dni) && noVacia(pass)) {
            ControladorCUIdentificarse.identificarEmpleado(dni, pass); // Decidir qué retorna

            // Si error, notificar a la vista
            // Si empleado identificado, mostrar Vista de Acciones según el rol
        } else {
            // Muestra mensaje de error correspondiente
            vista.mostrarMensajeError(ERROR_CAMPOS_VACIOS);
        }
        
    }
    
    /**
     * Comprueba que la cadena no sea ni nula ni esté vacía.
     * @param param Cadena
     * @return True si no esta vacía, false si sí lo está.
     */
    private boolean noVacia(String param) {
        return param != null && !param.isEmpty();
    }
    
}
