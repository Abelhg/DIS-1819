package registro.vista;

import java.sql.SQLException;
import registro.modelo.UtilTemperaturas;
import registro.modelo.Temperatura;
import registro.vista.VistaRegistro;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import registro.modelo.Registro;

/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class ControladorVista {
    
    private final int NUM_DECIMALES = 3;
    
    private final Registro registro;
    private final VistaRegistro vista;
    
    public ControladorVista(Registro registro, VistaRegistro vista){
        this.registro = registro;
        this.vista = vista;
        actualizarValores();
    }
    
    /**
     * Procesa evento de añadir nueva temperatura comprobando si los datos
     * son correctos. Luego muestra un diálogo de confirmación.
     * @param temperatura
     * @param unidad 
     */
    public void añadirNuevaTemperatura(String temperatura, int unidad){
        // Comprueba dato vacío
        if(temperatura == null || temperatura.trim().isEmpty()) return;
        // Valida los datos
        float temp;
        int unid;
        try{
            temp = Float.parseFloat(temperatura);
        }catch(Exception e){
            // Muestra diálogo de error
            vista.mostrarDialogoError(temperatura);
            return;
        }
        
        if(Temperatura.comprobarValorTemperatura(temp, unidad)){
            // Muestra dialogo de confirmación
            vista.mostrarDialogoConfirmacion(temp, unidad);
        }else{
            // Muestra diálogo de error
            vista.mostrarDialogoError(temperatura);
        }
    }
    
    /**
     * Añade la temperatura al registro tras confirmar el diálogo.
     * @param valor
     * @param unidad
     */
    public void añadirConfirmado(float valor, int unidad){
        try {
            // Añade la temperatura al registro
            registro.añadirTemperatura(LocalDateTime.now(), valor, unidad);
            // Actualiza las estadísticas
            actualizarValores();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fahrenheitSeleccionado(){
        registro.cambiarUnidadActual(UtilTemperaturas.FAHRENHEIT);
        actualizarValores();
    }
    
    public void celsiusSeleccionado(){
        registro.cambiarUnidadActual(UtilTemperaturas.CELSIUS);
        actualizarValores();
    }
    
    public void kelvinSeleccionado(){
        registro.cambiarUnidadActual(UtilTemperaturas.KELVIN);
        actualizarValores();
    }
    
    public void actualizarValores(){
        String grados = UtilTemperaturas.getTextoUnidad(registro.getUnidadActual());
        vista.setTemperaturaMaxima(String.format("%." + NUM_DECIMALES + "f " + grados, 
                registro.getTemperaturaMaxima().getValor()));
        vista.setTemperaturaMinima(String.format("%." + NUM_DECIMALES + "f " + grados, 
                registro.getTemperaturaMinima().getValor()));
        vista.setTemperaturaMedia(String.format("%." + NUM_DECIMALES + "f " + grados, 
                registro.getTemperaturaMedia().getValor()));

        // Por si acaso se introduce un número muy grande, para que se
        // incremente el tamaño de la ventana
        vista.pack();
    }
    
}
