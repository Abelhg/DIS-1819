package es.uva.eii.ds.empresaX.interfaz.pares_vista_control.empleado;

import es.uva.eii.ds.empresaX.interfaz.GestorDeInterfazDeUsuario;
import es.uva.eii.ds.empresaX.negocio.controladoresCasoUso.ControladorCUIdentificarse;
import es.uva.eii.ds.empresaX.negocio.modelos.Sesion;

/**
 * Controlador de la vista de identificación.
 * 
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class CtrlVistaIdentificarse {
    
    private final VistaIdentificarse vista;
    
    // MENSAJES DE ERROR
    public static final String ERROR_CAMPOS_VACIOS = "No puede haber campos vacíos";
    public static final String ERROR_PASS_INCORRECTA = "Contraseña incorrecta";
    public static final String ERROR_DNI_NO_EXISTENTE = "El DNI no existe";
    public static final String ERROR_INESPERADO = "Error inesperado";
    
    /**
     * Inicializa el controlador.
     * @param v Vista que controla
     */
    public CtrlVistaIdentificarse(VistaIdentificarse v) {
        vista = v;
        // Oculta el mensaje de error
        vista.borrarMensajeError();
        // Centra en la pantalla
        vista.setLocationRelativeTo(null);
    }
    
    /**
     * Procesa la petición de conexión de un usuario.
     */
    public void procesaEventoIdentificarse() {
        vista.borrarMensajeError();
        
        // Obtiene los datos introducidos y comprueba no vacío
        String dni  = vista.getDNI();
        String pass = vista.getPassword();
        
        if(!compruebaCharArrayNoVacio(dni)) {
            // Muestra mensaje de error correspondiente
            vista.mostrarMensajeError(ERROR_CAMPOS_VACIOS);
            // Y hace focus en el campo del DNI
            vista.hacerFocusDNI();
            return;
        }
        
        if(!compruebaCharArrayNoVacio(pass)) {
            // Muestra mensaje de error correspondiente
            vista.mostrarMensajeError(ERROR_CAMPOS_VACIOS);
            // Y hace focus en el campo del password
            vista.hacerFocusPassword();
            return;
        }
        
        String error = ControladorCUIdentificarse.getInstanciaSingleton().
                                    identificarEmpleado(dni, pass);

        Sesion sesion = Sesion.getInstanciaSingleton();
        if(error != null && sesion.getEmpleado() == null) {
            // No existe el empleado. Muestra el correspondiente error.
            vista.mostrarMensajeError(error);
        } else {
            // Empleado conectado con éxito, le muestra ventana con las opciones
            GestorDeInterfazDeUsuario.getInstanciaSingleton().
                    empleadoIdentificado(sesion.getEmpleado().obtenerRolActual().getTipo());
        }
        
    }
    
    /**
     * Comprueba que la cadena no sea ni nula ni esté vacía.
     * @param param Cadena
     * @return True si no esta vacía, false si sí lo está.
     */
    private boolean compruebaCharArrayNoVacio(String param) {
        return param != null && !param.isEmpty();
    }
    
}
