package es.uva.eii.ds.empresaX.persistencia;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import es.uva.eii.ds.empresaX.servicioscomunes.JSONHelper;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class FachadaPersistenciaEmpleadoHorno {
    
    // Devuelve los pedidos cuya fecha en la quese quiere está en un rango
    private static final String QUERY_PEDIDOS_POR_FECHA =
            "SELECT * FROM PEDIDODEHORNO PDH WHERE PDH.FECHAENLAQUESEQUIERE BETWEEN (?) AND (?)";
            
    
    /*
            "SELECT * FROM OperacionSobrePedidoDeHorno OP, EstadoDePedidoDeHorno EP, PedidoHorno PH "
            + "INNER JOIN ON OP.tipo = EP.idTipo INNER JOIN OP.pedidoDeHorno = PH.numeroDePedido "
            + "WHERE nombreTipo = 'Registrado' AND fechaEnLaQueSeQuiere BETWEEN (?) AND (?)";*/
    
    
    private static ConexionBD conectarse() throws ClassNotFoundException, SQLException {
        return ConexionBD.getInstancia();
    }
    public static String getListaPedidosPendientes(LocalDate inicio, LocalDate fin) {
        JsonArray arrayPedidos = new JsonArray();
        
        try {
            ConexionBD conn = conectarse();
            PreparedStatement pst = conn.prepareStatement(QUERY_PEDIDOS_POR_FECHA);
            pst.setDate(1, Date.valueOf(inicio));
            pst.setDate(2, Date.valueOf(fin));
            
            // Resultados: pedidos en un rango de fechas. Hay que obtener los que están pendientes solo
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                JsonObject pedido = new JsonObject();
                
                
                

                // Datos básicos del pedido
                pedido.addProperty(JSONHelper.JSON_NUM_PEDIDO, rs.getInt("NUMERODEPEDIDO"));
                pedido.addProperty(JSONHelper.JSON_FECHA_DESEADA, rs.getDate("FECHAENLAQUESEQUIERE").toString());
                
                
                
                
                // Cliente del pedido
                
            }
           
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FachadaPersistenciaEncargado.class.getName()).log(Level.SEVERE, null, ex);
        }
         JsonObject pedidosPendientes = new JsonObject();
         pedidosPendientes.add(JSONHelper.JSON_FACTURAS_PENDIENTES, arrayPedidos);
            
         return pedidosPendientes.toString();
    }
    
}
