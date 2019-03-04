package Modelo;

import java.time.LocalDate;

/**
 * @author Abel Herrero Gómez   (abeherr)
 */
public class Registro {
    private Temperatura temperatura;
    private Momento momento;
    
    public Registro(Temperatura temperatura, Momento momento){
        this.temperatura = temperatura;
        this.momento = momento;
    }

    public Temperatura getTemperatura() {
        return temperatura;
    }

    public Momento getMomento() {
        return momento;
    }
    
}
