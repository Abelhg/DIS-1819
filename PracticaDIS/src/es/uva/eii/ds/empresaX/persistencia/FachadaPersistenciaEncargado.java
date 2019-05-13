package es.uva.eii.ds.empresaX.persistencia;

import es.uva.eii.ds.empresaX.negocio.modelos.Factura;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class FachadaPersistenciaEncargado {
    
        // FACTURAS PENDIENTES DE PAGO
    // Devuelve el año de la primera fecha de emisión
    private static final String QUERY_MIN_ANIO_FAC = "SELECT YEAR(fechaDeEmision) FROM Factura WHERE ... = (?)";  
    // Devuelve el año de la última fecha de emisión
    private static final String QUERY_MAX_ANIO_FAC = "SELECT YEAR(fechaDeEmision) FROM Factura WHERE ... = (?)";
    // Devuelve las facturas pendientes, en el rango de fechas especificado, para el proveedor especificado
    private static final String QUERY_FACTURAS_PEND = "SELECT * FROM ... WHERE ... AND fechaEmision >= (?) AND fechaEmision <= (?) AND proveedor = (?)";  
    
    private static ConexionBD conectarse() throws ClassNotFoundException, SQLException {
        return ConexionBD.getInstancia();
    }
    
    /**
     * Devuelve el año de la primera factura.
     * @return Año de la primera factura
     */
    public static int getMinAnioFacturas() {
        // TODO
        return 2014;
    }
    
    /**
     * Devuelve el año de la última factura.
     * @return Año de la última factura
     */
    public static int getMaxAnioFacturas() {
        // TODO
        return 2019;
    }
    
    /**
     * Devuelve las facturas pendientes de pago en el rango de fechas seleccionado
     * y para el proveedor requerido.
     * @param fechaI Fecha mínima de emisión
     * @param fechaF Fecha máxima de emisión
     * @param proveedor Proveedor del pedido
     * @return Facturas que cumplen los requisitos de búsqueda
     */
    public static ArrayList<Factura> getFacturasPendientesDePago(
                        LocalDate fechaI, LocalDate fechaF, String proveedor) {
        
        ArrayList<Factura> facturas = null;
        
        
        
        return facturas;
    }
   
}
