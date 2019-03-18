package registro.modelo;

/**
 * Clase utilidad que declara las unidades de medida de temperaturas y
 * proporciona funciones para la conversión entre ellas.
 * 
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class UtilTemperaturas {
    public static final int CELSIUS = 0;
    public static final int FAHRENHEIT = 1;
    public static final int KELVIN = 2;
    public static final float CERO_ABS = -273.15f; // Celsius

    private UtilTemperaturas() {} // No deja crear instancias
    
    /**
     * Transforma una temperatura a Celsius.
     * @param temp una Temperatura.
     * @return la temperatura convertida a Celsius.
     */
    public static Temperatura aCelsius(Temperatura temp){
        float c;
        switch(temp.getUnidad()){
            case CELSIUS:
                c = temp.getValor();
                break;
            case FAHRENHEIT:
                c = 5*(temp.getValor() - 32) / 9;
                break;
            case KELVIN:
                c = temp.getValor() + CERO_ABS;
                break;
            default:
                System.out.println("[!] Constante no conocida: " + temp.getUnidad());
                c = temp.getValor();
        }
        
        return new Temperatura(c, CELSIUS);
    }
    
    /**
     * Transforma una temperatura a Fahrenheit.
     * @param temp una Temperatura.
     * @return la temperatura convertida a Fahrenheit.
     */
    public static Temperatura aFahrenheit(Temperatura temp){
        float f;
        switch(temp.getUnidad()){
            case CELSIUS:
                f = (9 * temp.getValor() / 5) + 32;
                break;
            case FAHRENHEIT:
                f = temp.getValor();
                break;
            case KELVIN:
                f = (9 * (temp.getValor() + CERO_ABS)) / 5 + 32;
                break;
            default:
                System.out.println("[!] Constante no conocida: " + temp.getUnidad());
                f = temp.getValor();
        }
        
        return new Temperatura(f, FAHRENHEIT);
    }
    
    /**
     * Transforma una temperatura a Kelvin.
     * @param temp una Temperatura.
     * @return la temperatura convertida a Kelvin.
     */
    public static Temperatura aKelvin(Temperatura temp){
        float k;
        switch(temp.getUnidad()){
            case CELSIUS:
                k = temp.getValor() - CERO_ABS;
                break;
            case FAHRENHEIT:
                k = 5 * (temp.getValor() - 32) / 9 - CERO_ABS;
                break;
            case KELVIN:
                k = temp.getValor();
                break;
            default:
                System.out.println("[!] Constante no conocida: " + temp.getUnidad());
                k = temp.getValor();
        }
        
        return new Temperatura(k, KELVIN);
    }
    
    /**
     * Devuelve la notación para la unidad deseada. Ejemplo: para grados Celsius
     * devuelve "ºC", para Fahrenheit devuelve "ºF" y para Kelvin devuelve "ºK".
     * @param unidad
     * @return Texto unidad
     */
    public static String getTextoUnidad(int unidad){
        String res = "º"; // Unidad
        switch(unidad){
            case CELSIUS:
                res += "C";
                break;
            case FAHRENHEIT:
                res += "F";
                break;
            case KELVIN:
                res += "K";
                break;
        }
        
        return res;
    }

}


    
    
    

