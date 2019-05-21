package es.uva.eii.ds.empresaX.interfaz.pares_vista_control.dependiente;

import com.google.gson.Gson;
import es.uva.eii.ds.empresaX.interfaz.GestorUI;
import es.uva.eii.ds.empresaX.negocio.controladoresCasoUso.ControladorCURegistrarVenta;
import es.uva.eii.ds.empresaX.negocio.modelos.ProductoVendible;
import es.uva.eii.ds.empresaX.negocio.modelos.Venta;
import javax.swing.JFrame;
import es.uva.eii.ds.empresaX.negocio.modelos.LineaDeVenta;

/**
 * Controlador de la vista de registro de venta directa.
 * 
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class CtrlVistaRegistrarVentaDirecta {
    
    private final VistaRegistrarVentaDirecta vista;
    
    /**
     * Inicializa el controlador.
     * @param v Vista que controla
     */
    public CtrlVistaRegistrarVentaDirecta(VistaRegistrarVentaDirecta v) {
        vista = v;
        // Evita que termine el programa al cerrar la ventana
        vista.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // Centra en la pantalla
        vista.setLocationRelativeTo(null);
    }
    
    /**
     * Cuando se cierra la ventana, se vuelve a la anterior.
     */
    public void procesaCierre() {
        GestorUI.getInstanciaSingleton().atras();
    }
    
    public void creaLineaDeVenta(String codigo,String cantidad,String[] listaProductos){
                
        Venta venta;
        
        if(listaProductos.length == 0){
            venta = new Venta();
        }
        
        if(Integer.parseInt(cantidad) < 1){
            //Mensaje de error
        }
        
        String prod = ControladorCURegistrarVenta.compruebaExistenciaProducto(codigo);
        ProductoVendible pVendible = new Gson().fromJson(prod, ProductoVendible.class);
        
        if(prod == null){
            //Mensaje de error
        }else if(pVendible.getExistencias() < Integer.parseInt(cantidad)){
            //Otro mensaje de error
        }
        
        LineaDeVenta lVenta = getLineaDeVentaPorProducto(codigo);
        
        if(lVenta == null){
            ProductoVendible p = ControladorCURegistrarVenta.crearProducto(codigo);
            lVenta = ControladorCURegistrarVenta.crearLineaDeVenta(codigo,cantidad);
        }else{
            lVenta = sumaCantidad(lVenta,cantidad);
        }
        
        //VistaRegistrarVentaDirecta.mostrarDatosVenta(venta);
        
    }

    private LineaDeVenta getLineaDeVentaPorProducto(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private LineaDeVenta sumaCantidad(LineaDeVenta lVenta, String cantidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void finalizarVenta(boolean hacerFactura){
        
        VistaRegistrarVentaDirecta.mostrarPrecioFinal();
        
        if(hacerFactura){
            //Hacer factura
        }
        
        //ControladorCURegistrarVenta.registrarVenta(venta);
        
    }
    
}
