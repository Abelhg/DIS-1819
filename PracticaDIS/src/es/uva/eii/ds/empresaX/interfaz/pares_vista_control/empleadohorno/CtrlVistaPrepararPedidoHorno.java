package es.uva.eii.ds.empresaX.interfaz.pares_vista_control.empleadohorno;

import es.uva.eii.ds.empresaX.interfaz.GestorUI;
import es.uva.eii.ds.empresaX.negocio.controladoresCasoUso.ControladorCUPedido;
import javax.swing.JFrame;


/**
 * Controlador de la vista de consulta de facturas pendientes de pago.
 * 
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class CtrlVistaPrepararPedidoHorno {
    
    private final VistaPrepararPedidoHorno vista;
    
    /**
     * Inicializa el controlador.
     * @param v Vista que controla
     */
    public CtrlVistaPrepararPedidoHorno(VistaPrepararPedidoHorno v) {
        vista = v;
        // Evita que termine el programa al cerrar la ventana
        vista.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // Centra en la pantalla
        vista.setLocationRelativeTo(null);
        // Carga los pedidos para hoy o mañana
        vista.cargaListaPedidos(ControladorCUPedido.getListaPedidosRegistradosHorno());
    }
    
    /**
     * Cuando se cierra la ventana, se vuelve a la anterior.
     */
    public void procesaCierre() {
        GestorUI.getInstanciaSingleton().atras();
    }
    
    
    
}
