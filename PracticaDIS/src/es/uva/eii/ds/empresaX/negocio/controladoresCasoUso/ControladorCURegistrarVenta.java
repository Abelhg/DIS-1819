/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.ds.empresaX.negocio.controladoresCasoUso;

import com.google.gson.JsonObject;
import es.uva.eii.ds.empresaX.negocio.modelos.LineaDeVenta;
import es.uva.eii.ds.empresaX.negocio.modelos.ProductoVendible;
import es.uva.eii.ds.empresaX.negocio.modelos.Venta;
import es.uva.eii.ds.empresaX.persistencia.FachadaPersistenciaDependiente;

/**
 * @author Abel Herrero Gómez (abeherr)
 * @author Daniel De Vicente Garrote (dandevi)
 * @author Roberto García Antoranz (robegar)
 */
public class ControladorCURegistrarVenta {

    public static JsonObject compruebaExistenciaProducto(String codigo) {
        
        JsonObject prod = FachadaPersistenciaDependiente.getProductoBD(codigo);
        return prod;
        
    }

    public static ProductoVendible crearProducto(JsonObject prod) {
        ProductoVendible pv = new ProductoVendible(prod.get("codigo").getAsString(),prod.get("nombre").getAsString(),prod.get("descripcion").getAsString(),prod.get("existencias").getAsInt(),prod.get("cantMin").getAsInt(),prod.get("precio").getAsDouble());
        return pv;
    }

    public static Venta crearLineaDeVenta(ProductoVendible prod, int cantidad,Venta venta) {
        LineaDeVenta lv = new LineaDeVenta(cantidad,prod);
        venta.getLineas().add(lv);
        return venta;
    }
    
    public static void registrarVenta(Venta venta){
        FachadaPersistenciaDependiente.setVentaBD(venta);
    }
    
    public static void actualizarExistencias(Venta venta){
        FachadaPersistenciaDependiente.actualizarExistenciasBD(venta);
    }

    public static int getCantidadDisponible(ProductoVendible pVendible, Venta venta) {
        int res = pVendible.getExistencias();
        for(LineaDeVenta lv : venta.getLineas()){
            if(lv.getProducto().getCodigo().equals(pVendible.getCodigo()))
                res -= lv.getCantidad();
        }
        return res;
    }
        
}
