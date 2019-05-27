/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.ds.empresaX.negocio.controladoresCasoUso;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import es.uva.eii.ds.empresaX.negocio.modelos.PedidoDeHorno;
import es.uva.eii.ds.empresaX.persistencia.FachadaPersistenciaEmpleadoHorno;
import es.uva.eii.ds.empresaX.servicioscomunes.JSONHelper;
import es.uva.eii.ds.empresaX.servicioscomunes.MessageException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class ControladorCUPedido {

    /**
     * Devuelve una lista de pedidos en estado 'Registrado' con fechas de
     * entrega deseada del día actual y el siguiente.
     * @return Lista o null si ha ocurrido algún error
     */
    public static ArrayList<PedidoDeHorno> getListaPedidosRegistradosHorno() {
        ArrayList<PedidoDeHorno> listaPedidos = new ArrayList<>();
        
        // Lista de pedidos de hoy y mañana
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        
        // Consulta la BD
        String resultadoListaPedidos = "";
        try {
            resultadoListaPedidos = FachadaPersistenciaEmpleadoHorno.getListaPedidosPendientes(today, tomorrow);
        } catch(MessageException e) {
            // Error controlado
            return null;
        }
        
        // Genera la lista de pedidos
        JsonObject jsonResultado = new Gson().fromJson(resultadoListaPedidos, JsonObject.class);
        JsonArray jArrayPedidos = jsonResultado.getAsJsonArray(JSONHelper.JSON_PEDIDOS_PENDIENTES);
        for(JsonElement jPedido : jArrayPedidos) {
            listaPedidos.add(new PedidoDeHorno(jPedido.toString()));
        }
        
        return listaPedidos;
    }
    
}
