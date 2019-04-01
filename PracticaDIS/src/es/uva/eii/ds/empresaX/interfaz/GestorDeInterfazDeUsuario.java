package es.uva.eii.ds.empresaX.interfaz;

import es.uva.eii.ds.empresaX.interfaz.pares_vista_control.rol1.VentanaGestionEmpleados;
import es.uva.eii.ds.empresaX.interfaz.pares_vista_control.empleado.VistaIdentificarse;
import java.util.Stack;
import javax.swing.JFrame;

public class GestorDeInterfazDeUsuario { 
    private Stack<JFrame> anteriores;
    private JFrame actual;
    
    private static GestorDeInterfazDeUsuario instancia;
    
    private GestorDeInterfazDeUsuario() {
        // Muestra la pantalla principal
        login();
    }
    
    /**
     * Muestra la ventana con el formulario de conexión de los empleados.
     */
    public void login() {
        guardaActual();
        
        java.awt.EventQueue.invokeLater(() -> {
            actual = new VistaIdentificarse();
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
        }else{
            System.out.println("[!] Ya existe una instancia de GestorDeInterfazDeUsuario.");
        }
        
        return instancia;
    }

}
