package es.uva.eii.ds.empresaX.interfaz.pares_vista_control.encargado;

import es.uva.eii.ds.empresaX.interfaz.GestorUI;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import javax.swing.JFrame;


/**
 * Controlador de la vista de consulta de facturas pendientes de pago.
 * 
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class CtrlVistaConsultarFacturas {
    
    private final VistaConsultarFacturas vista;
    
    /**
     * Inicializa el controlador.
     * @param v Vista que controla
     */
    public CtrlVistaConsultarFacturas(VistaConsultarFacturas v) {
        vista = v;
        // Evita que termine el programa al cerrar la ventana
        vista.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // Centra en la pantalla
        vista.setLocationRelativeTo(null);
    }
    
    /**
     * Procesa el evento de click en la casilla de selección de facturas pendientes
     * en el año actual. Inhabilita los selectores de fechas.
     */
    public void procesaClickAnioActual() {
        System.out.println(1);
        if(vista.facturasAnioActual()) {
            // Marcada -> inhabilita la selección de fechas
            vista.inhabilitaFechas();
            vista.desmarcaTodas();       // Desmarca la otra opción
            vista.focusProveedor(false); // Solo focus
        } else {
            // Desmarcada -> habilita la selección de fechas
            vista.habilitaFechas();
        }
    }
    
    /**
     * Procesa el evento de click en la casilla de selección de todas las 
     * facturas pendientes.
     */
    public void procesaClickTodas() {
        System.out.println(2);
        if(vista.facturasTodas()) {
            // Marcada -> inhabilita la selección de fechas
            vista.inhabilitaFechas();
            vista.desmarcaAnioActual();  // Desmarca la otra opción
            vista.focusProveedor(false); // Solo focus
        } else {
            // Desmarcada -> habilita la selección de fechas
            vista.habilitaFechas();
        }
    }
    
    /**
     * Procesa el evento de click en el botón de generación de la consulta.
     */
    public void procesaClickConsultar() {
        if(vista.facturasAnioActual()) {
            // Opción de facturas del año actual marcada.
        } else if(vista.facturasTodas()) {
            // Opción de todas las facturas
        } else {
            // Obtiene las fechas y comprueba que son válidas
            LocalDate fechaI;
            LocalDate fechaF;
            try {
                fechaI = LocalDate.of(vista.getAnioInicio(), 
                                      vista.getMesInicio(), 
                                      vista.getDiaInicio());
            } catch (DateTimeException e) {
                // La fecha de inicio no es válida
                vista.mostrarErrorFechas("La fecha de inicio no es válida");
                return;
            }
            try {
                fechaF = LocalDate.of(vista.getAnioFin(), 
                                      vista.getMesFin(), 
                                      vista.getDiaFin());
            } catch (DateTimeException e) {
                // La fecha de fin no es válida
                vista.mostrarErrorFechas("La fecha de fin no es válida");
                return;
            }
        }
        
        // Obtiene el proveedor, comprueba que no esté vacío
        String proveedor = vista.getProveedor();
        if(proveedor != null && !proveedor.isEmpty()) {
            // Comprueba que el proveedor especificado existe
            // TODO
            boolean existe = false;
            if(existe) {
                // TODO Busca las facturas en la BD
            } else {
                vista.mostrarErrorProveedor("Proveedor no existente");
            }
        }
        
    }
    
    /**
     * Procesa un cambio en el input del proveedor. Quita el mensaje de error.
     */
    public void procesaCambioProveedor() {
        vista.ocultarErrorProveedor();
    }
    
    /**
     * Cuando se cierra la ventana, se vuelve a la anterior.
     */
    public void procesaCierre() {
        GestorUI.getInstanciaSingleton().atras();
    }
    
}
