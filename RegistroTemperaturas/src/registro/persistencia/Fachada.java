package registro.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import registro.modelo.Temperatura;

/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class Fachada {
    
    private static ConexionBD conectarse() throws ClassNotFoundException{
        return ConexionBD.getInstancia();
    }
    
    public static ArrayList<Temperatura> getTemperaturas(){
        ArrayList<Temperatura> result = new ArrayList<>();
        try{
            ConexionBD conn = conectarse();
            String qTemperaturas = "SELECT valor, unidad FROM TEMPERATURAS";
            ResultSet rs = conn.consulta(qTemperaturas);
            while (rs.next()){
                result.add(new Temperatura(rs.getFloat("valor"), rs.getInt("unidad")));
            }
            conn.closeConnection();
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(Fachada.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    public static void agrega(LocalDateTime momento, Temperatura nueva) throws SQLException{
        try {
            ConexionBD conn = conectarse();
            
            String insert = "INSERT INTO TEMPERATURAS VALUES ('" + 
                            Timestamp.valueOf(momento) + "', " +
                            nueva.getValor() + ", " + nueva.getUnidad() + ")";
            System.out.println(insert);
            conn.inserta(insert);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Fachada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
