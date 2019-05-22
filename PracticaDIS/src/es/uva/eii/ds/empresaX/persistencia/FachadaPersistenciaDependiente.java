/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.ds.empresaX.persistencia;

import es.uva.eii.ds.empresaX.negocio.modelos.LineaDeVenta;
import es.uva.eii.ds.empresaX.negocio.modelos.Venta;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Abel Herrero Gómez (abeherr)
 * @author Daniel De Vicente Garrote (dandevi)
 * @author Roberto García Antoranz (robegar)
 */
public class FachadaPersistenciaDependiente {

    private static final String QUERY_ID_PRODUCTO = "SELECT * FROM Producto WHERE CODIGO = ?";

    private static final String QUERY_ID_VENTA_VENTA = "INSERT INTO VENTA VALUES(?,?,?)";
    private static final String QUERY_ID_VENTA_LINEA = "INSERT INTO LINEADEVENTA VALUES(?,?)";
    private static final String QUERY_ID_VENTA_PRODUCTO = "INSERT INTO PRODUCTO VALUES(?,?,?,?,?,?,?,?,?)";

    private static final String QUERY_EXISTENCIAS = "UPDATE PRODUCTO SET EXISTENCIAS = ? WHERE CODIGO = ?";

    private static ConexionBD conectarse() throws ClassNotFoundException, SQLException {
        return ConexionBD.getInstancia();
    }

    public static String getProductoBD(String codigo) {

        String cif = null;
        try {
            ConexionBD conn = conectarse();
            PreparedStatement pst = conn.prepareStatement(QUERY_ID_PRODUCTO);
            pst.setString(1, codigo);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String res = "{\"codigo\":\"" + rs.getString("codigo") + "\",\"nombre\":" + rs.getString("nombre") + "\",\"nombre\":" + "{\"codigo\":\"" + rs.getString(codigo) + "\",\"descripcion\":" + rs.getString("descripcion") + "\",\"existencias\":" + rs.getInt("existencias") + "\",\"cantidadminimaenstock\":" + rs.getInt("cantidadminimaenstock") + "\",\"subtipo\":" + rs.getInt("subtipo") + "\",\"precio\":" + rs.getInt("precio") + "\",\"diasparaentregadelproveedor\":" + rs.getInt("diasparaentregadelproveedor") + "\",\"tipodemateriaprima\":" + rs.getInt("tipodemateriaprima");
                return res;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FachadaPersistenciaEncargado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void setVentaBD(Venta venta) {

        try {
            ConexionBD conn = conectarse();
            for (LineaDeVenta lp : venta.getLineas()) {
                PreparedStatement pst = conn.prepareStatement(QUERY_ID_VENTA_PRODUCTO);
                pst.setString(1, lp.getProducto().getCodigo());
                pst.setString(2, lp.getProducto().getNombre());
                pst.setString(3, lp.getProducto().getDescripcion());
                pst.setInt(4, lp.getProducto().getExistencias());
                pst.setInt(5, lp.getProducto().getCantidadMinimaEnStock());
                pst.setString(6, "");
                pst.setDouble(7, lp.getProducto().getPrecioVenta());
                pst.setInt(8, -1);
                pst.setString(9, "");
                int rs = pst.executeUpdate();
            }
            
            for (LineaDeVenta lp : venta.getLineas()) {
                PreparedStatement pst = conn.prepareStatement(QUERY_ID_VENTA_LINEA);
                pst.setInt(1, lp.getCantidad());
                pst.setString(2, lp.getProducto().getCodigo());
                int rs = pst.executeUpdate();
            }
            
            PreparedStatement pst = conn.prepareStatement(QUERY_ID_VENTA_VENTA);
            pst.setInt(1, venta.getIdDeVenta());
            pst.setDate(2, new Date(venta.getFechaDeVenta().toEpochDay()));
            pst.setString(3, "");
            int rs = pst.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FachadaPersistenciaEncargado.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void actualizarExistenciasBD(Venta venta) {

        try {
            ConexionBD conn = conectarse();
            for (LineaDeVenta lp : venta.getLineas()) {
                PreparedStatement pst1 = conn.prepareStatement("SELECT * FROM PRODUCTO WHERE CODIGO = ?");
                pst1.setString(1, lp.getProducto().getCodigo());
                ResultSet rs1 = pst1.executeQuery();
                rs1.next();
                PreparedStatement pst2 = conn.prepareStatement(QUERY_ID_VENTA_PRODUCTO);
                pst2.setInt(1, rs1.getInt("existencias")-lp.getCantidad());
                pst2.setString(2, lp.getProducto().getCodigo());
                int rs2 = pst2.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FachadaPersistenciaEncargado.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
