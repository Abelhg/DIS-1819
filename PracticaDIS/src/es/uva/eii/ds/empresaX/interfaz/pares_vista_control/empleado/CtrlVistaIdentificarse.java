package es.uva.eii.ds.empresaX.interfaz.pares_vista_control.empleado;

public class CtrlVistaIdentificarse {
    private VistaIdentificarse vista;
    
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
        if(dni == null  || dni.isEmpty()) {
            // Muestra mensaje de error correspondiente
            // TODO
            return;
        }
        if(pass == null || pass.isEmpty()) {
            // Muestra mensaje de error correspondiente
            // TODO
            return;
        }
        
        // Llamada identificarEmpleado(dni, pass) a ControladorCUIdentificarse
        // Decidir qué retorna
        
        // Si empleado identificado, llamar al GestorDeInterfaz
    }
}
