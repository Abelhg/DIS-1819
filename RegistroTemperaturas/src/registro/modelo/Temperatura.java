package registro.modelo;

/**
 * Representa un valor de temperatura con la unidad correspondiente.
 * 
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class Temperatura {
    public static final float TEMPERATURA_MAXIMA = 200;
    public static final float TEMPERATURA_MINIMA = UtilTemperaturas.CERO_ABS;
    
    private final float valor;
    private final int unidad; /* Ver constantes en la clase UnidadTemperatura */

    /**
     * Construye un objeto Temperatura con el valor y unidad especificados.
     * @param valor Valor de la temperatura
     * @param unidad Unidad de medida
     */
    public Temperatura(float valor, int unidad) {
        this.valor = valor;
        this.unidad = unidad;
    }

    public float getValor() {
        return valor;
    }
    
    /* Ver constantes en la clase UnidadTemperatura */
    public int getUnidad(){
        return unidad;
    }
    
    /**
     * Comprueba si el valor de una temperatura es válida, según su unidad.
     * @param valor Valor de la temperatura
     * @param unidad Unidad de medida
     * @return true si es válida, false si no
     */
    public static boolean comprobarValorTemperatura(float valor, int unidad){
        // Transforma a Celsius
        float cTemp = UtilTemperaturas.aCelsius(
                        new Temperatura(valor, unidad)).getValor();
        // Luego comprueba
        return (cTemp >= TEMPERATURA_MINIMA) && (cTemp <= TEMPERATURA_MAXIMA);
    }
    
}
