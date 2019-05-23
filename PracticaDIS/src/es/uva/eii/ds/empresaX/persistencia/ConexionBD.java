package es.uva.eii.ds.empresaX.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class ConexionBD {
    
    private final String url;
    private final String usuario;
    private final String password;
    private Connection connection;
    
    private ConexionBD() throws ClassNotFoundException, SQLException {
        url = "jdbc:derby://localhost:1527/bd_pasteleria";
        usuario = "temp";
        password = "temp";
        
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        openConnection();
    }
    
    
    public void openConnection() throws SQLException {
        connection = DriverManager.getConnection(url, usuario, password);
    }
    
    public void closeConnection() throws SQLException {
        connection.close();
    }
    
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    /** Alcance de clase **/
    private static ConexionBD theInstance;
    public static ConexionBD getInstancia() throws ClassNotFoundException, SQLException {
        if(theInstance == null){
            theInstance = new ConexionBD();
        }
        
        return theInstance;
    }
    
}