package registro;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;

/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class Registro {
    private String nombre;
    private HashMap<LocalDateTime, Temperatura> mediciones;
    private int UNIDAD_ACTUAL = UtilTemperaturas.CELSIUS; // Por defecto
    
    /**
     * Crea un registro con el nombre especificado. Los valores por defecto
     * de las temperaturas máxima y mínima son 100ºC y -273.15ºC, respectivamente.
     * @param nombre Nombre del registro
     */
    public Registro(String nombre) {
        this.nombre = nombre;
        mediciones = new HashMap<>();
    }

    /**
     * Agrega una temperatura a la estructura de datos según una clave temporal.
     * @param momento Momento de la temperatura
     * @param nueva Temperatura a añadir
     */
    private void agregar(LocalDateTime momento, Temperatura nueva) {
        mediciones.put(momento, nueva);
    }

    /**
     * Añade una nueva temperatura al registro.
     * @param momento Momento de la medición
     * @param temperatura Valor de la temperatura
     * @param unidad Unidad de medida
     */
    public void añadirTemperatura(LocalDateTime momento, float temperatura, int unidad) {
        Temperatura nueva = new Temperatura(temperatura, unidad);
        agregar(momento, nueva);
    }

    /**
     * Devuelve la temperatura media en el registro.
     * @return Temperatura media del registro
     */
    public Temperatura getTemperaturaMedia() {
        Collection<Temperatura> temperaturas = mediciones.values();
        float total = 0;
        for (Temperatura t : temperaturas) {
            total += convertirAActual(t).getValor();
        }
        
        return new Temperatura(total / temperaturas.size(), UNIDAD_ACTUAL);
    }

    /**
     * Devuelve la temperatura con el valor más grande en el registro.
     * @return Temperatura máxima del registro
     */
    public Temperatura getTemperaturaMaxima() {
        Collection<Temperatura> temperaturas = mediciones.values();
        Temperatura max = null;
        Temperatura temp;
        // Para cada temperatura, la transforma a Celsius y comprueba si
        // es más pequeña que la mínima actual
        for (Temperatura t : temperaturas) {
            temp = convertirAActual(t);
            if(max == null || temp.getValor() > max.getValor()){
                max = temp;
            }
        }
        
        return max;
    }

    /**
     * Devuelve la temperatura con el valor más pequeño en el registro.
     * @return Temperatura mínima del registro
     */
    public Temperatura getTemperaturaMinima() {
        Collection<Temperatura> temperaturas = mediciones.values();
        Temperatura min = null;
        Temperatura temp;
        // Para cada temperatura, la transforma a Celsius y comprueba si
        // es más pequeña que la mínima actual
        for (Temperatura t : temperaturas) {
            temp = convertirAActual(t);
            if(min == null || temp.getValor() < min.getValor()){
                min = temp;
            }
        }
        
        return min;
    }
    
    /**
     * Convierte una temperatura a la temperatura actual.
     * @param temp Temperatura a convertir
     * @return Temperatura convertida
     */
    public Temperatura convertirAActual(Temperatura temp){
        Temperatura res = null;
        switch(UNIDAD_ACTUAL){
            case UtilTemperaturas.CELSIUS:
                res = UtilTemperaturas.aCelsius(temp);
                break;
            case UtilTemperaturas.FAHRENHEIT:
                res = UtilTemperaturas.aFahrenheit(temp);
                break;
            case UtilTemperaturas.KELVIN:
                res = UtilTemperaturas.aKelvin(temp);
                break;
        }
        
        return res;
    }
    
    /**
     * Cambia la unidad actual de medida a la especificada.
     * @param nUnidad Nueva unidad de medida
     */
    public void cambiarUnidadActual(int nUnidad){
        UNIDAD_ACTUAL = nUnidad;
    }
    
    /**
     * Devuelve la unidad actual de medida
     * @return Unidad de medida
     */
    public int getUnidadActual(){
        return UNIDAD_ACTUAL;
    }

    /**
     * Devuelve el nombre del registro.
     * @return Nombre del registro
     */
    public String getNombre() {
        return nombre;
    }
    
}

