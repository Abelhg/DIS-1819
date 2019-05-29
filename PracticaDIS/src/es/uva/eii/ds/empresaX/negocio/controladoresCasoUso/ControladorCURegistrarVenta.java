package es.uva.eii.ds.empresaX.negocio.controladoresCasoUso;

import com.google.gson.JsonObject;
import es.uva.eii.ds.empresaX.negocio.modelos.LineaDeVenta;
import es.uva.eii.ds.empresaX.negocio.modelos.ProductoVendible;
import es.uva.eii.ds.empresaX.negocio.modelos.Venta;
import es.uva.eii.ds.empresaX.persistencia.FachadaPersistenciaDependiente;
import es.uva.eii.ds.empresaX.servicioscomunes.MessageException;
import java.util.ArrayList;

/**
 * @author Abel Herrero Gómez (abeherr)
 * @author Daniel De Vicente Garrote (dandevi)
 * @author Roberto García Antoranz (robegar)
 */
public class ControladorCURegistrarVenta {

    public static JsonObject compruebaExistenciaProducto(String codigo) throws MessageException {
        
        JsonObject prod = FachadaPersistenciaDependiente.getProductoBD(codigo);
        return prod;
        
    }

    public static ProductoVendible crearProducto(JsonObject prod) {
        ProductoVendible pv = new ProductoVendible(prod.get("codigo").getAsString(),prod.get("nombre").getAsString(),prod.get("descripcion").getAsString(),prod.get("existencias").getAsInt(),prod.get("cantMin").getAsInt(),prod.get("precio").getAsDouble());
        return pv;
    }

    public static ArrayList<LineaDeVenta> crearLineaDeVenta(ProductoVendible prod, int cantidad,ArrayList<LineaDeVenta> lineasVenta) {
        LineaDeVenta lv = new LineaDeVenta(cantidad,prod);
        lineasVenta.add(lv);
        return lineasVenta;
    }
    
    public static void registrarVenta(ArrayList<LineaDeVenta> lineasVenta,String cifEmpleado) throws MessageException{
        Venta venta = new Venta(cifEmpleado,lineasVenta);
        FachadaPersistenciaDependiente.setVentaBD(cifEmpleado,venta);
    }
    
    public static void actualizarExistencias(ArrayList<LineaDeVenta> lineasVenta) throws MessageException{
        FachadaPersistenciaDependiente.actualizarExistenciasBD(lineasVenta);
    }

    public static int getCantidadDisponible(ProductoVendible pVendible, ArrayList<LineaDeVenta> lineasVenta) {
        int res = pVendible.getExistencias();
        for(LineaDeVenta lv : lineasVenta){
            if(lv.getProducto().getCodigo().equals(pVendible.getCodigo()))
                res -= lv.getCantidad();
        }
        return res;
    }
        
}
