/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    
    private static final String QUERY_ID_PEDIDOS = "SELECT * FROM PedidoDehorno WHERE UPPER(FechaEnLaQueSeQuiere) = (?) OR (?)";
    
    
    private static ConexionBD conectarse() throws ClassNotFoundException, SQLException {
        return ConexionBD.getInstancia();
    }
    public static JsonObject getListaPedidosPendientes() {
        JsonArray arrayPedidos = new JsonArray();

        try {
            ConexionBD conn = conectarse();
            PreparedStatement pst = conn.prepareStatement(QUERY_ID_PEDIDOS);
            LocalDate hoy =  LocalDate.now();
            LocalDate tomorrow =  hoy.plusDays(1);
            Date fechaActual =  java.sql.Date.valueOf(hoy);
            Date fechaTomorrow = java.sql.Date.valueOf(tomorrow);
            pst.setDate(1, fechaActual);
            pst.setDate(2, fechaTomorrow);
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                JsonObject pedido = new JsonObject();
                
                pedido.addProperty(JSONHelper.JSON_NUM_PEDIDO, rs.getInt("NUMERODEPEDIDO"));
                pedido.addProperty(JSONHelper.JSON_FECHA_DESEADA, rs.getDate("FECHAENLAQUESEQUIERE").toString());

                arrayPedidos.add(pedido);
            }
           
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FachadaPersistenciaEncargado.class.getName()).log(Level.SEVERE, null, ex);
        }
         JsonObject pedidosPendientes = new JsonObject();
         pedidosPendientes.add(JSONHelper.JSON_FACTURAS_PENDIENTES, arrayPedidos);
            
         return pedidosPendientes;
    }
    
}
