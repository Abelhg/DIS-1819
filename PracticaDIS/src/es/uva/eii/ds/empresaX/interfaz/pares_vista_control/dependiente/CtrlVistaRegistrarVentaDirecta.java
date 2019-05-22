package es.uva.eii.ds.empresaX.interfaz.pares_vista_control.dependiente;

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
    private Venta venta = new Venta();
    
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
    
    public void creaLineaDeVenta(String codigo,String cantidad){
        
        if(Integer.parseInt(cantidad) < 1){
            //Mensaje de error
        }
        
        String prod = ControladorCURegistrarVenta.compruebaExistenciaProducto(codigo);
        ProductoVendible pVendible = ControladorCURegistrarVenta.crearProducto(codigo);
        LineaDeVenta lVenta = getLineaDeVentaPorProducto(codigo,venta);
        
        if(prod == null){
            //Mensaje de error
        }else if(pVendible.getExistencias() < Integer.parseInt(cantidad)+lVenta.getCantidad()){
            //Otro mensaje de error
        }
        
        if(lVenta == null){
            venta = ControladorCURegistrarVenta.crearLineaDeVenta(pVendible,cantidad,venta);
        }else{
            venta = sumaCantidad(lVenta,cantidad);
        }
        
        VistaRegistrarVentaDirecta.mostrarDatosVenta(venta);
        
    }

    private LineaDeVenta getLineaDeVentaPorProducto(String codigo,Venta venta) {
        
        for(LineaDeVenta lp : venta.getLineas()){
            if(lp.getProducto().getCodigo().equals(codigo)){
                return lp;
            }
        }
        return null;
    }

    private Venta sumaCantidad(LineaDeVenta lVenta,String cantidad) {
        
        lVenta.setCantidad(lVenta.getCantidad()+Integer.parseInt(cantidad));
        return venta;
        
    }
    
    public void finalizarVenta(boolean hacerFactura){
        
        VistaRegistrarVentaDirecta.mostrarPrecioFinal();
        
        if(hacerFactura){
            //Hacer factura
        }
        
        ControladorCURegistrarVenta.registrarVenta(venta);
        
        ControladorCURegistrarVenta.actualizarExistencias(venta);
        
    }
    
}
