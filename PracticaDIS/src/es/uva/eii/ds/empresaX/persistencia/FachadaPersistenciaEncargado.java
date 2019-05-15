package es.uva.eii.ds.empresaX.persistencia;

import es.uva.eii.ds.empresaX.negocio.modelos.FacturaPendiente;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Abel Herrero Gómez (abeherr)
 * @author Daniel De Vicente Garrote (dandevi)
 * @author Roberto García Antoranz (robegar)
 */
public class FachadaPersistenciaEncargado {

    // FACTURAS PENDIENTES DE PAGO
    // Devuelve el ID del proveedor especificado
    private static final String QUERY_ID_PROVEEDOR = "SELECT cif FROM Proveedor WHERE UPPER(nombre) = (?)";
    // Devuelve el año de la primera fecha de emisión
    private static final String QUERY_MIN_ANIO_FAC = "SELECT YEAR(fechaDeEmision) FROM Factura WHERE ... = (?)";
    // Devuelve el año de la última fecha de emisión
    private static final String QUERY_MAX_ANIO_FAC = "SELECT YEAR(fechaDeEmision) FROM Factura WHERE ... = (?)";
    // Devuelve las facturas pendientes, en el rango de fechas especificado, para el proveedor especificado
    private static final String QUERY_FACTURAS_PEND
            = "SELECT * FROM "
            + "Factura INNER JOIN PedidoAProveedor ON Factura.pedido = PedidoAProveedor.numeroDePedido "
            + "WHERE fechaDeEmision >= (?) AND fechaDeEmision <= (?) AND proveedor = (?) AND enTransferencia IS NULL";

    private static ConexionBD conectarse() throws ClassNotFoundException, SQLException {
        return ConexionBD.getInstancia();
    }

    /**
     * Devuelve el año de la primera factura.
     *
     * @return Año de la primera factura
     */
    public static int getMinAnioFacturas() {
        // TODO
        return 2014;
    }

    /**
     * Devuelve el año de la última factura.
     *
     * @return Año de la última factura
     */
    public static int getMaxAnioFacturas() {
        // TODO
        return 2019;
    }

    /**
     * Devuelve el id de un proveedor en la BD con el nombre especificado.
     *
     * @param proveedor Nombre de proveedor
     * @return ID del proveedor (null si no existe)
     */
    public static String getCIFProveedor(String proveedor) {
        String cif = null;
        try {
            ConexionBD conn = conectarse();
            PreparedStatement pst = conn.prepareStatement(QUERY_ID_PROVEEDOR);
            pst.setString(1, proveedor.toUpperCase());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                cif = rs.getString("cif");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FachadaPersistenciaEncargado.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cif;
    }

    /**
     * Devuelve las facturas pendientes de pago en el rango de fechas
     * seleccionado y para el proveedor requerido.
     *
     * @param fechaI Fecha mínima de emisión
     * @param fechaF Fecha máxima de emisión
     * @param proveedor Proveedor del pedido
     * @return Facturas que cumplen los requisitos de búsqueda
     */
    public static ArrayList<FacturaPendiente> getFacturasPendientesDePago(
            LocalDate fechaI, LocalDate fechaF, String proveedor) {

        ArrayList<FacturaPendiente> facturas = new ArrayList<>();

        try {

            if (proveedor != null) {
                ConexionBD conn = conectarse();
                PreparedStatement pst = conn.prepareStatement(QUERY_FACTURAS_PEND);
                pst.setDate(1, Date.valueOf(fechaI));
                pst.setDate(2, Date.valueOf(fechaF));
                pst.setString(3, proveedor);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    long numeroPedido = rs.getLong("pedido");
                    double importe = rs.getFloat("importe");
                    LocalDate fechaPedido = rs.getDate("fechaDeRealizacion").toLocalDate();
                    LocalDate fechaEmision = rs.getDate("fechaDeEmision").toLocalDate();
                    facturas.add(new FacturaPendiente(proveedor, numeroPedido, importe, fechaPedido, fechaEmision));
                }

            } else {
                ConexionBD conn = conectarse();

                PreparedStatement pst1 = conn.prepareStatement("SELECT * FROM Factura JOIN Pedidoaproveedor ON Factura.Pedido = Pedidoaproveedor.Numerodepedido");
                ResultSet rs1 = pst1.executeQuery();

                while (rs1.next()) {
                    long numeroPedido = rs1.getLong("pedido");
                    double importe = rs1.getFloat("importe");
                    LocalDate fechaPedido = rs1.getDate("fechaDeRealizacion").toLocalDate();
                    LocalDate fechaEmision = rs1.getDate("fechaDeEmision").toLocalDate();

                    facturas.add(new FacturaPendiente(rs1.getString("Proveedor"), numeroPedido, importe, fechaPedido, fechaEmision));
                }

            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FachadaPersistenciaEncargado.class.getName()).log(Level.SEVERE, null, ex);
            facturas = null;
        }

        return facturas;
    }

}
