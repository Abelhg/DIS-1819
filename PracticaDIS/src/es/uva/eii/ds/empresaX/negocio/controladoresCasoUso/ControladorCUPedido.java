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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class ControladorCUPedido {

    public static List<PedidoDeHorno> getListaPedidosPendientes() {
        List<PedidoDeHorno> listaPedidos = new ArrayList<PedidoDeHorno>();
        
        // Lista de pedidos de hoy y mañana
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        
        // Consulta la BD
        String resultadoListaPedidos = FachadaPersistenciaEmpleadoHorno.getListaPedidosPendientes(today, tomorrow);
        
        // Comprueba que no ha habido ningún error
        JsonObject jsonResultado = new Gson().fromJson(resultadoListaPedidos, JsonObject.class);
        if(jsonResultado.has("error")) {
            // Ha ocurrido un error
            // TODO
            String mensajeError = jsonResultado.get("error").getAsString();
        } else {
            // Genera la lista de pedidos
            JsonArray jArrayPedidos = jsonResultado.getAsJsonArray(JSONHelper.JSON_PEDIDOS_PENDIENTES);
            for(JsonElement jPedido : jArrayPedidos) {
                listaPedidos.add(new PedidoDeHorno(jPedido.toString()));
            }
        }
        
        return listaPedidos;
    }
    
}
