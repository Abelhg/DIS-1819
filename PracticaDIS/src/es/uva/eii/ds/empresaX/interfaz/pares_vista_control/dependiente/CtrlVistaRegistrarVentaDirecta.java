package es.uva.eii.ds.empresaX.interfaz.pares_vista_control.dependiente;

import com.google.gson.JsonObject;
import es.uva.eii.ds.empresaX.interfaz.GestorUI;
import es.uva.eii.ds.empresaX.negocio.controladoresCasoUso.ControladorCURegistrarVenta;
import es.uva.eii.ds.empresaX.negocio.modelos.ProductoVendible;
import es.uva.eii.ds.empresaX.negocio.modelos.Venta;
import javax.swing.JFrame;
import es.uva.eii.ds.empresaX.negocio.modelos.LineaDeVenta;
import java.util.ArrayList;

/**
 * Controlador de la vista de registro de venta directa.
 *
 * @author Abel Herrero Gómez (abeherr)
 * @author Daniel De Vicente Garrote (dandevi)
 * @author Roberto García Antoranz (robegar)
 */
public class CtrlVistaRegistrarVentaDirecta {

    private final VistaRegistrarVentaDirecta vista;
    private static ArrayList<LineaDeVenta> lineasVenta;

    private final static String errorCantidadIncorrecta = "La cantidad introducida es menos que uno. Vuelva a introducir una cantidad correcta";
    private final static String errorProductoInexistente = "El código introducido no pertenece a ningún producto en la lista de productos existente";
    private final static String errorCantidadNoRelaizable = "No existen unidades suficientes para ese producto";
    private final static String errorListaVacia = "No hay productos introducidos en la lista";

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

    public void introducirProducto(String codigo, String cant) {
        
        if(lineasVenta == null) lineasVenta = new ArrayList<>();
        
        if(cant.isEmpty()){
            VistaError vistaError = new VistaError(errorCantidadIncorrecta);
            vistaError.setLocationRelativeTo(null);
            vistaError.setVisible(true);
        }else{
        
        int cantidad = Integer.parseInt(cant);

        if (cantidad < 1) {
            VistaError vistaError = new VistaError(errorCantidadIncorrecta);
            vistaError.setLocationRelativeTo(null);
            vistaError.setVisible(true);
        } else {

            if (codigo.isEmpty()) {
                VistaError vistaError = new VistaError(errorProductoInexistente);
                vistaError.setLocationRelativeTo(null);
                vistaError.setVisible(true);
            } else {

                JsonObject prod = ControladorCURegistrarVenta.compruebaExistenciaProducto(codigo);

                if (prod == null) {
                    VistaError vistaError = new VistaError(errorProductoInexistente);
                    vistaError.setLocationRelativeTo(null);
                    vistaError.setVisible(true);
                } else {

                    ProductoVendible pVendible = ControladorCURegistrarVenta.crearProducto(prod);
                    int cantDisp = ControladorCURegistrarVenta.getCantidadDisponible(pVendible, lineasVenta);

                    if (cantDisp < cantidad) {
                        VistaError vistaError = new VistaError(errorCantidadNoRelaizable);
                        vistaError.setLocationRelativeTo(null);
                        vistaError.setVisible(true);
                    } else {
                        lineasVenta = ControladorCURegistrarVenta.crearLineaDeVenta(pVendible, cantidad, lineasVenta);
                        vista.mostrarDatosVenta(lineasVenta);
                    }
                }
            }
        }
        }

    }
    
    public void finalizarVenta(String cifEmpleado) {

        if (lineasVenta != null || lineasVenta.size() > 0) {

            /*double total = getTotalVenta();
            VistaPrecioTotal vistaPrecio = new VistaPrecioTotal(total);
            vistaPrecio.setLocationRelativeTo(null);
            vistaPrecio.setVisible(true);*/

            ControladorCURegistrarVenta.registrarVenta(lineasVenta,cifEmpleado);

            ControladorCURegistrarVenta.actualizarExistencias(lineasVenta);

            vista.borrarLista();
            GestorUI.getInstanciaSingleton().atras();

        } else {
            VistaError vistaError = new VistaError(errorListaVacia);
            vistaError.setLocationRelativeTo(null);
            vistaError.setVisible(true);
        }

    }

    private double getTotalVenta() {
        double res = 0;
        for (LineaDeVenta lv : lineasVenta) {
            res += lv.getCantidad() * lv.getProducto().getPrecioVenta();
        }
        return res;
    }

    void vaciaLista() {
        lineasVenta = null;
    }

}
