/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.ds.empresaX.negocio.controladoresCasoUso;

import com.google.gson.JsonObject;
import es.uva.eii.ds.empresaX.negocio.modelos.PedidoDeHorno;
import es.uva.eii.ds.empresaX.persistencia.FachadaPersistenciaEmpleadoHorno;
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
        JsonObject listaPedidosJson = FachadaPersistenciaEmpleadoHorno.getListaPedidosPendientes();
      
        
    }
    
}
