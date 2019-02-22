package dis1;

import java.time.LocalDate;

/**
 * @author Abel Herrero Gómez   (abeherr)
 */
public class RegistroTemperatura {
    private final double temperatura;
    private final LocalDate momento;
    
    public RegistroTemperatura(double temperatura, LocalDate momento){
        this.temperatura = temperatura;
        this.momento = momento;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public LocalDate getMomento() {
        return momento;
    }
    
}
