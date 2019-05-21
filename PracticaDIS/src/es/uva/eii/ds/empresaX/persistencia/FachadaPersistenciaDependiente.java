/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.ds.empresaX.persistencia;

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
                String res = "{\"codigo\":\""+rs.getString("codigo")+"\",\"nombre\":"+rs.getString("nombre")+"\",\"nombre\":"+"{\"codigo\":\""+rs.getString(codigo)+"\",\"descripcion\":"+rs.getString("descripcion")+"\",\"existencias\":"+rs.getInt("existencias")+"\",\"cantidadminimaenstock\":"+rs.getInt("cantidadminimaenstock")+"\",\"subtipo\":"+rs.getInt("subtipo")+"\",\"precio\":"+rs.getInt("precio")+"\",\"diasparaentregadelproveedor\":"+rs.getInt("diasparaentregadelproveedor")+"\",\"tipodemateriaprima\":"+rs.getInt("tipodemateriaprima");
                return res;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FachadaPersistenciaEncargado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
