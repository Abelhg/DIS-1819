package es.uva.eii.ds.empresaX.persistencia;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import es.uva.eii.ds.empresaX.negocio.modelos.Empleado;
import es.uva.eii.ds.empresaX.servicioscomunes.MessageException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class FachadaPersistenciaEncargado {
    
    private static final String QUERY_PROVEEDOR = "SELECT * FROM ... WHERE proveedor = (?)";
    private static final String QUERY_FACTURAS = "SELECT * FROM ...";  
    private static final String QUERY_FACTURAS_TODAS = "SELECT * FROM ...";
    private static final String QUERY_FACTURAS_ANIO = "SELECT * FROM ...";
    
    private static ConexionBD conectarse() throws ClassNotFoundException, SQLException {
        return ConexionBD.getInstancia();
    }
    
    
    // TODO
   
}
