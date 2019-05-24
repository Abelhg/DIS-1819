package es.uva.eii.ds.empresaX.interfaz.pares_vista_control.dependiente;

import com.google.gson.JsonObject;
import es.uva.eii.ds.empresaX.interfaz.GestorUI;
import es.uva.eii.ds.empresaX.negocio.controladoresCasoUso.ControladorCURegistrarVenta;
import es.uva.eii.ds.empresaX.negocio.modelos.ProductoVendible;
import es.uva.eii.ds.empresaX.negocio.modelos.Venta;
import javax.swing.JFrame;
import es.uva.eii.ds.empresaX.negocio.modelos.LineaDeVenta;

/**
 * Controlador de la vista de registro de venta directa.
 *
 * @author Abel Herrero Gómez (abeherr)
 * @author Daniel De Vicente Garrote (dandevi)
 * @author Roberto García Antoranz (robegar)
 */
public class CtrlVistaRegistrarVentaDirecta {

    private final VistaRegistrarVentaDirecta vista;
    private static Venta venta;

    /**
     * Inicializa el controlador.
     *
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

    public void introducirProducto(String codigo, int cantidad) {

        if (cantidad < 1) {
            //Mensaje de error
        } else {

            if (venta == null) {
                venta = new Venta(/*id del empleado,*/);
            }

            JsonObject prod = ControladorCURegistrarVenta.compruebaExistenciaProducto(codigo);

            if (prod == null) {
                //Mensaje de error
            } else {

                ProductoVendible pVendible = ControladorCURegistrarVenta.crearProducto(prod);
                int cantDisp = ControladorCURegistrarVenta.getCantidadDisponible(pVendible, venta);

                if (cantDisp < cantidad) {
                    //Otro mensaje de error
                } else {
                    venta = ControladorCURegistrarVenta.crearLineaDeVenta(pVendible, cantidad, venta);
                    vista.mostrarDatosVenta(venta);
                }
            }
        }

    }

    private Venta sumaCantidad(LineaDeVenta lVenta, int cantidad) {

        lVenta.setCantidad(lVenta.getCantidad() + cantidad);
        return venta;

    }

    public void finalizarVenta() {

        if (venta.getLineas().size() > 0) {

            /*VistaPrecioTotal vistaPrecio = new VistaPrecioTotal();
            double total = getTotalVenta();
            vistaPrecio.mostrarPrecioFinal(total);
            vistaPrecio.setVisible(true);*/

            /*if (hacerFactura) {
                //Hacer factura
            }*/

            ControladorCURegistrarVenta.registrarVenta(venta);

            ControladorCURegistrarVenta.actualizarExistencias(venta);
            
            vista.borrarLista();
            GestorUI.getInstanciaSingleton().atras();

        }else{
            //Mensaje de error
        }

    }

    private double getTotalVenta() {
        double res = 0;
        for (LineaDeVenta lv : venta.getLineas()) {
            res += lv.getCantidad()*lv.getProducto().getPrecioVenta();
        }
        return res;
    }

}
