package es.uva.eii.ds.empresaX.interfaz;

import es.uva.eii.ds.empresaX.interfaz.pares_vista_control.rol1.VentanaGestionEmpleados;
import es.uva.eii.ds.empresaX.interfaz.pares_vista_control.empleado.VistaIdentificarse;
import es.uva.eii.ds.empresaX.interfaz.pares_vista_control.empleado.VistaListaOpciones;
import es.uva.eii.ds.empresaX.negocio.modelos.TipoRol;
import java.util.Stack;
import javax.swing.JFrame;

/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class GestorDeInterfazDeUsuario { 
    private Stack<JFrame> anteriores;
    private JFrame actual;
    
    private static GestorDeInterfazDeUsuario instancia;
    
    private GestorDeInterfazDeUsuario() {
        anteriores = new Stack<>();
        // Muestra la pantalla principal
        vistaIdentificarse();
    }
    
    /**
     * Muestra la ventana con el formulario de conexión de los empleados.
     */
    private void vistaIdentificarse() {
        guardaActual();
        
        java.awt.EventQueue.invokeLater(() -> {
            actual = new VistaIdentificarse();
            actual.setVisible(true);
        });  
    }
    
    /**
     * Muestra la ventana con la lista de opciones del usuario según su rol.
     * @param rol Rol del usuario
     */
    public void empleadoIdentificado(TipoRol rol) {
        guardaActual(); // ¿Guarda actual? Si cierra, ¿vuelve a la ventana de login?
        
        java.awt.EventQueue.invokeLater(() -> {
            actual = new VistaListaOpciones(rol);
            actual.setVisible(true);
        }); 
    }

    /**
     * Muestra la ventana con el panel de gestión de los empleados.
     */
    public void gestionarEmpleados() {
        guardaActual();
       
        java.awt.EventQueue.invokeLater(() -> {
            actual = new VentanaGestionEmpleados();
            actual.setVisible(true);
        });
    }
    
    /**
     * Guarda el estado actual en la pila.
     */
    private void guardaActual() {
        if(actual != null){
            anteriores.push(actual);
            actual.setVisible(false);
        }
    }
    
    /**
     * Vuelve a la vista anterior.
     */
    public void atras() {
       actual.dispose();
       actual = anteriores.pop();
       actual.setVisible(true);
    }
    
    
    /*****     SINGLETON     *****/
    /**
     * Devuelve una instancia única para la clase.
     * @return Instancia única
     */
    public static GestorDeInterfazDeUsuario getInstanciaSingleton() {
        if(instancia == null){
            instancia = new GestorDeInterfazDeUsuario();
        }
        
        return instancia;
    }

}
