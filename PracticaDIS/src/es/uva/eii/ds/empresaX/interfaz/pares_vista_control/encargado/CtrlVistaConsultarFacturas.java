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
        // Deshabilita el botón de consultar
        vista.deshabilitaBotonConsultar();
        // Evita que termine el programa al cerrar la ventana
        vista.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // Centra en la pantalla
        vista.setLocationRelativeTo(null);
    }
    
    /**
     * Carga los años para los que pueden existir facturas, buscando el año más bajo
     * y el más alto.
     */
    public void cargaAnios() {
        // Consulta en la BD el año más bajo
        // TODO
        int minAnio = 1970;
        // Consulta en la BD el año más alto
        // TODO
        int maxAnio = 2019;
        
        // Obtiene los años entre medias y los mete en un array
        String[] anios = new String[maxAnio-minAnio+1];
        for(int i = minAnio; i <= maxAnio; i++) {
            anios[i-minAnio] = Integer.toString(i);
        }
        
        // Se los manda a la vista
        vista.cambiaAnios(anios);
    }
    
    /**
     * Procesa el evento de click en la casilla de selección de facturas pendientes
     * en el año actual. Inhabilita los selectores de fechas.
     */
    public void procesaClickAnioActual() {
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
        vista.ocultaErrorFechas();
        vista.ocultarErrorProveedor();
        
        if(vista.facturasAnioActual()) {
            // Opción de facturas del año actual marcada.
            // TODO
        } else if(vista.facturasTodas()) {
            // Opción de todas las facturas
            // TODO
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
                vista.muestraErrorFechas("La fecha de inicio no es válida");
                return;
            }
            try {
                fechaF = LocalDate.of(vista.getAnioFin(), 
                                      vista.getMesFin(), 
                                      vista.getDiaFin());
            } catch (DateTimeException e) {
                // La fecha de fin no es válida
                vista.muestraErrorFechas("La fecha de fin no es válida");
                return;
            }
            
            // Comprueba que las fechas están ordenadas
            if(fechaI.isAfter(fechaF)) {
                vista.muestraErrorFechas("La fecha de fin debe ser posterior a la de inicio");
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
                // Busca las facturas en la BD
                // TODO
            } else {
                vista.mostrarErrorProveedor("Proveedor no existente");
            }
        }
        
    }
    
    
    /**
     * Procesa el evento de cambio de mes de inicio de la búsqueda, actualizando
     * los días válidos para dicho mes.
     */
    public void procesaCambioFechaInicio() {
        int dia = vista.getDiaInicio();
        int mes = vista.getMesInicio();
        int anio = vista.getAnioInicio();
        vista.cambiaDiasInicio(getDiasMes(mes, anio));
    }
    
    /**
     * Procesa el evento de cambio de mes de fin de la búsqueda, actualizando
     * los días válidos para dicho mes.
     */
    public void procesaCambioFechaFin() {
        int mes = vista.getMesFin();
        int anio = vista.getAnioFin();
        vista.cambiaDiasFin(getDiasMes(mes, anio));
    }
    
    /**
     * Procesa un cambio en el input del proveedor. Quita el mensaje de error.
     */
    public void procesaCambioProveedor() {
        vista.ocultarErrorProveedor();
        if(vista.getProveedor().isEmpty()) {
            vista.deshabilitaBotonConsultar();
        } else {
            vista.habilitaBotonConsultar();
        }
    }
    
    /**
     * Cuando se cierra la ventana, se vuelve a la anterior.
     */
    public void procesaCierre() {
        GestorUI.getInstanciaSingleton().atras();
    }
    
    /**
     * Devuelve un array de enteros con los días del mes especificado. Tiene en
     * cuenta si el año es bisiesto.
     * @param mes Mes deseado (1-12)
     * @return Dias del mes en array
     */
    private String[] getDiasMes(int mes, int anio) {
        int n;
        switch (mes) {
            case 4:
            case 6:
            case 9:
            case 11:
                n = 30;
                break;
            case 2:
                if(esBisiesto(anio)) {
                    n = 29;
                } else {
                    n = 28;
                }
                break;
            default:
                n = 31;
                break;
        }
        
        String[] dias = new String[n];
        for(int i = 0; i < n; i++) {
            dias[i] = Integer.toString(i+1);
        }
        
        return dias;
    }
    
    /**
     * Devuelve true si el año especificado es bisiesto.
     * @param anio Año
     * @return True si es bisiesto
     */
    private boolean esBisiesto(int anio) {
        return (anio % 4 == 0) && ( (anio % 100 != 0) || (anio % 400 == 0) );
    }
}
