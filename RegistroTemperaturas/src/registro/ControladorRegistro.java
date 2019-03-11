package registro;

import java.time.LocalDateTime;

/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class ControladorRegistro {
    
    private final int NUM_DECIMALES = 3;
    
    private final Registro registro;
    private final VistaRegistro vista;
    
    public ControladorRegistro(Registro registro, VistaRegistro vista){
        this.registro = registro;
        this.vista = vista;
    }
    
    /**
     * Procesa evento de añadir nueva temperatura comprobando si los datos
     * son correctos. Luego muestra un diálogo de confirmación.
     * @param temperatura
     * @param unidad 
     */
    public void añadirNuevaTemperatura(String temperatura, String unidad){
        // Comprueba dato vacío
        if(temperatura == null || temperatura.trim().isEmpty()) return;
        // Valida los datos
        float temp;
        int unid;
        try{
            temp = Float.parseFloat(temperatura);
            unid = Integer.parseInt(unidad);
        }catch(Exception e){
            // Muestra diálogo de error
            vista.mostrarDialogoError(temperatura);
            return;
        }
        
        if(Temperatura.comprobarValorTemperatura(temp, unid)){
            // Muestra dialogo de confirmación
            vista.mostrarDialogoConfirmacion(temp, unid);
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
        // Añade la temperatura al registro
        registro.añadirTemperatura(LocalDateTime.now(), valor, unidad);
        // Actualiza las estadísticas
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
        vista.setLocationRelativeTo(null);
    }
    
}
