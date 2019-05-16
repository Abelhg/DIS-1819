package es.uva.eii.ds.empresaX.negocio.controladoresCasoUso;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import es.uva.eii.ds.empresaX.negocio.modelos.Factura;
import es.uva.eii.ds.empresaX.persistencia.FachadaPersistenciaEncargado;
import es.uva.eii.ds.empresaX.servicioscomunes.JSONHelper;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControladorCUConsultarFacturas {
    
    /**
     * Devuelve la lista de facturas pendientes para los datos introducidos.
     * @param fechaInicio Fecha de inicio
     * @param fechaFin Fecha de fin
     * @param proveedor Proveedor (null para cualquiera)
     * @return Lista de facturas pendientes
     */
    public ArrayList<Factura> obtenerFacturasPendientes(LocalDate fechaInicio, 
                                                                 LocalDate fechaFin, 
                                                                 String proveedor) {
        ArrayList<Factura> pendientes = new ArrayList<>();
        
        // Obtiene el JSON de la BD
        String jsonFacturas = FachadaPersistenciaEncargado.
                                getFacturasPendientesDePago(fechaInicio, fechaFin, proveedor);
        
        // Genera los objetos
        JsonObject jo = new Gson().fromJson(jsonFacturas, JsonObject.class);
        JsonArray facturasPendientes = jo.getAsJsonArray(JSONHelper.JSON_FACTURAS_PENDIENTES);
        for(JsonElement factura : facturasPendientes) {
            pendientes.add(new Factura(factura.toString()));
        }
        
        return pendientes;
    }
    
    /**
     * Devuelve el CIF para el nombre de un proveedor dado.
     * @param proveedor Nombre del proveedor
     * @return CIF del proveedor
     */
    public static String getCIFProveedor(String proveedor) {
        return FachadaPersistenciaEncargado.getCIFProveedor(proveedor);
    }
    
    
    /*****     SINGLETON     *****/
    /**
     * Devuelve una instancia única para la clase.
     * @return Instancia única
     */
    private static ControladorCUConsultarFacturas instancia;
    public static ControladorCUConsultarFacturas getInstanciaSingleton() {
        if(instancia == null){
            instancia = new ControladorCUConsultarFacturas();
            }
        
        return instancia;
    }
    
}
