package es.uva.eii.ds.empresaX.interfaz.pares_vista_control.empleado;

import es.uva.eii.ds.empresaX.negocio.controladoresCasoUso.ControladorCUIdentificarse;
import es.uva.eii.ds.empresaX.negocio.modelos.Empleado;

/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class CtrlVistaIdentificarse {
    
    private final VistaIdentificarse vista;
    
    // MENSAJES DE ERROR
    public static final String ERROR_CAMPOS_VACIOS = "No puede haber campos vacíos";
    public static final String ERROR_CREDENCIALES_INVALIDAS = "DNI o contraseña incorrectos"; // Mensaje general
    public static final String ERROR_PASS_INCORRECTA = "Contraseña incorrecta";               // Mensajes específicos
    public static final String ERROR_DNI_NO_EXISTENTE = "El DNI no existe";
    public static final String ERROR_INESPERADO = "Error inesperado";
    public static final String ERROR_CREDENCIALES_VALIDAS = "¡Conectado!";
    
    
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
        
        Empleado empleado = ControladorCUIdentificarse.getInstanciaSingleton().
                                    identificarEmpleado(dni, pass);

        if(empleado == null) {
            // No existe el empleado
            vista.mostrarMensajeError(ERROR_CREDENCIALES_INVALIDAS);
        } else {
            // Empleado conectado con éxito
            vista.mostrarMensajeError(ERROR_CREDENCIALES_VALIDAS);
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
