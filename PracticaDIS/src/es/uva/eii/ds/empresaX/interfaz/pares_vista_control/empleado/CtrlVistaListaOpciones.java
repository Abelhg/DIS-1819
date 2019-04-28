package es.uva.eii.ds.empresaX.interfaz.pares_vista_control.empleado;

import es.uva.eii.ds.empresaX.interfaz.GestorDeInterfazDeUsuario;
import es.uva.eii.ds.empresaX.negocio.modelos.TipoRol;
import javax.swing.JFrame;

/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class CtrlVistaListaOpciones {
    
    private final VistaListaOpciones vista;
    
    // OPCIONES DEPENDIENTE
    private final String DEPENDIENTE_ENTREGAR = "<html><center>ENTREGAR PEDIDO<br>A CLIENTE</center></html>";
    private final String DEPENDIENTE_REGISTRAR = "<html><center>REGISTRAR<br>VENTA DIRECTA</center></html>";
    
    // OPCIONES EMPLEADO DE HORNO
    private final String EMPLEADO_HORNO_PREPARAR = "<html><center>PREPARAR PEDIDO<br>DE HORNO</center></html>";
    private final String EMPLEADO_HORNO_INFORMAR = "<html><center>INFORMAR DE PREVISIÓN DE<br>MATERIA PRIMA NECESARIA</center></html>";
    
    // OPCIONES ENCARGADO
    private final String ENCARGADO_CONSULTAR = "<html><center>CONSULTAR FACTURAS<br>PENDIENTES DE PAGO</center></html>";
    private final String ENCARGADO_COMPROBAR = "<html><center>COMPROBAR<br>TRANSFERENCIAS</center></html>";
    
    public CtrlVistaListaOpciones(VistaListaOpciones v, TipoRol rol) {
        vista = v;
        // Asigna el titulo de la ventana
        vista.setTitulo(rol.toString());
        // Evita que termine el programa al cerrar la ventana
        vista.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // Centra en la pantalla
        vista.setLocationRelativeTo(null);
        
        switch(rol) {
            case Supervisor:
                // No aparece nada en el modelo (?)
                break;
            case Dependiente:
                vista.anadirOpcion(DEPENDIENTE_ENTREGAR);
                vista.anadirOpcion(DEPENDIENTE_REGISTRAR);
                break;
            case EmpleadoDeHorno:
                vista.anadirOpcion(EMPLEADO_HORNO_PREPARAR);
                vista.anadirOpcion(EMPLEADO_HORNO_INFORMAR);
                break;
            case Encargado:
                vista.anadirOpcion(ENCARGADO_CONSULTAR);
                vista.anadirOpcion(ENCARGADO_COMPROBAR);
                break;
        }
    }
    
    
    public void procesaClickOpcion() {
        // Obtiene cuál ha sido la opción seleccionada
        switch(vista.getOpcionSeleccionada()) {
            // DEPENDIENTE
            case DEPENDIENTE_ENTREGAR:
                GestorDeInterfazDeUsuario.getInstanciaSingleton().vistaEntregarPedido();
                break;
            case DEPENDIENTE_REGISTRAR:
                GestorDeInterfazDeUsuario.getInstanciaSingleton().vistaRegistrarVenta();
                break;
            // EMPLEADO DE HORNO
            case EMPLEADO_HORNO_PREPARAR:
                GestorDeInterfazDeUsuario.getInstanciaSingleton().vistaPrepararPedido();
                break;
            case EMPLEADO_HORNO_INFORMAR:
                GestorDeInterfazDeUsuario.getInstanciaSingleton().vistaInformarPrevision();
                break;
            // ENCARGADO
            case ENCARGADO_CONSULTAR:
                GestorDeInterfazDeUsuario.getInstanciaSingleton().vistaConsultarFacturas();
                break;
            case ENCARGADO_COMPROBAR:
                GestorDeInterfazDeUsuario.getInstanciaSingleton().vistaComprobarTransferencias();
                break;
        }
    }
    
}
