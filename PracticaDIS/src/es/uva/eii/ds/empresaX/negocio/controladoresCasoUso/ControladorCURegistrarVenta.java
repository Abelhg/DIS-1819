/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.ds.empresaX.negocio.controladoresCasoUso;

import com.google.gson.Gson;
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

    public static String compruebaExistenciaProducto(String codigo) {
        
        String prod = FachadaPersistenciaDependiente.getProductoBD(codigo);
        return prod;
        
    }

    public static ProductoVendible crearProducto(String prod) {
        return new Gson().fromJson(prod, ProductoVendible.class);
    }

    public static Venta crearLineaDeVenta(ProductoVendible prod, String cantidad,Venta venta) {
        LineaDeVenta lv = new LineaDeVenta(Integer.parseInt(cantidad),prod);
        venta.getLineas().add(lv);
        return venta;
    }
    
    public static void registrarVenta(Venta venta){
        FachadaPersistenciaDependiente.setVentaBD(venta);
    }
    
    public static void actualizarExistencias(Venta venta){
        FachadaPersistenciaDependiente.actualizarExistenciasBD(venta);
    }
        
}
