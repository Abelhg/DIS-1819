package es.uva.eii.ds.empresaX.interfaz.pares_vista_control.dependiente;

import es.uva.eii.ds.empresaX.interfaz.GestorUI;
import javax.swing.JFrame;

/**
 * Controlador de la vista de consulta de facturas pendientes de pago.
 * 
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class CtrlVistaRegistrarVentaDirecta {
    
    private final VistaRegistrarVentaDirecta vista;
    
    /**
     * Inicializa el controlador.
     * @param v Vista que controla
     */
    public CtrlVistaRegistrarVentaDirecta(VistaRegistrarVentaDirecta v) {
        vista = v;
        // Evita que termine el programa al cerrar la ventana
        vista.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // Centra en la pantalla
        vista.setLocationRelativeTo(null);
    }
    
    /**
     * Cuando se cierra la ventana, se vuelve a la anterior.
     */
    public void procesaCierre() {
        GestorUI.getInstanciaSingleton().atras();
    }
    
}
