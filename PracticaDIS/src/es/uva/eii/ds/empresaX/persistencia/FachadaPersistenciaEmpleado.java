package es.uva.eii.ds.empresaX.persistencia;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import es.uva.eii.ds.empresaX.interfaz.pares_vista_control.empleado.CtrlVistaIdentificarse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class FachadaPersistenciaEmpleado {
    
    private static final String QUERY_LOGIN_PASS = "SELECT * FROM Empleados WHERE nif = (?) AND password = (?)";
    private static final String QUERY_NIF = "SELECT * FROM Empleados WHERE nif = (?)";
    private static final String QUERY_ROLES = "SELECT * FROM RolesEnEmpresa WHERE empleado = (?)";
    private static final String QUERY_NOMBRE_TIPO = "SELECT nombreTipo FROM (?) WHERE idTipo = (?)";
    private static final String QUERY_VINCULACIONES = "SELECT * FROM VinculacionConLaEmpresa WHERE empleado = (?)";
    
    private static ConexionBD conectarse() throws ClassNotFoundException{
        return ConexionBD.getInstancia();
    }
    
    /**
     * Devuelve el nombre de un tipo de rol/vinculacion/disponibilidad según su ID.
     * @param conn Conexión a la BD
     * @param nombreTabla Nombre de la tabla en la que consultar (roles, vinculaciones...)
     * @param idTipo ID del tipo
     * @return Cadena asociada al ID
     * @throws SQLException 
     */
    private static String obtenerNombreTipo(ConexionBD conn, String nombreTabla, int idTipo) throws SQLException {
        String res = "DESCONOCIDO";
        
        PreparedStatement pst = conn.prepareStatement(QUERY_NOMBRE_TIPO);
        pst.setString(1, nombreTabla);
        pst.setInt(2, idTipo);
        ResultSet rs = conn.consulta(pst);
        if(rs.next()){
            res = rs.getString("nombreTipo");
        }
        
        return res;
    }
    
    /**
     * Devuelve un JsonArray con los roles del empleado especificado según su DNI.
     * @param conn Conexión a la BD
     * @param dniEmpleado DNI del empleado
     * @return JsonArray con los roles y su fecha de inicio asociada
     * @throws SQLException 
     */
    private static JsonArray obtenerRolesEmpleado(ConexionBD conn, String dniEmpleado) throws SQLException {
        JsonArray roles = new JsonArray();
        
        PreparedStatement pst = conn.prepareStatement(QUERY_ROLES);
        pst.setString(1, dniEmpleado);
        ResultSet rs = conn.consulta(pst);
        while(rs.next()){
            JsonObject rol = new JsonObject();
            rol.addProperty("rol", obtenerNombreTipo(conn, "TipoDeRol", rs.getInt("rol")));
            rol.addProperty("comienzo", rs.getDate("comienzoEnRol").toString());
            roles.add(rol);
        }
        
        return roles;
    }
    
    /**
     * Devuelve un JsonArray con las vinculaciones del empleado especificado según su DNI.
     * @param conn Conexión a la BD
     * @param dniEmpleado DNI del empleado
     * @return JsonArray con las vinculaciones y su fecha de inicio asociada
     * @throws SQLException 
     */
    private static JsonArray obtenerVinculacionesEmpleado(ConexionBD conn, String dniEmpleado) throws SQLException {
        JsonArray vinculaciones = new JsonArray();
        
        PreparedStatement pst = conn.prepareStatement(QUERY_VINCULACIONES);
        pst.setString(1, dniEmpleado);
        ResultSet rs = conn.consulta(pst);
        while(rs.next()){
            JsonObject vinculacion = new JsonObject();
            vinculacion.addProperty("vinculacion", obtenerNombreTipo(conn, "TipoDeVinculacion", rs.getInt("rol")));
            vinculacion.addProperty("comienzo", rs.getDate("inicio").toString());
            vinculaciones.add(vinculacion);
        }
        
        return vinculaciones;
    }
    
    /**
     * Devuelve un JsonArray con las disponibilidades del empleado especificado según su DNI.
     * @param conn Conexión a la BD
     * @param dniEmpleado DNI del empleado
     * @return JsonArray con las vinculaciones y su fecha de inicio asociada
     * @throws SQLException 
     */
    private static JsonArray obtenerDisponibilidadesEmpleado(ConexionBD conn, String dniEmpleado) throws SQLException {
        JsonArray disponibilidades = new JsonArray();
        
        PreparedStatement pst = conn.prepareStatement(QUERY_VINCULACIONES);
        pst.setString(1, dniEmpleado);
        ResultSet rs = conn.consulta(pst);
        while(rs.next()){
            JsonObject disponibilidad = new JsonObject();
            disponibilidad.addProperty("disponibilidad", obtenerNombreTipo(conn, "TipoDeDisponibilidad", rs.getInt("rol")));
            disponibilidad.addProperty("comienzo", rs.getDate("comienzo").toString());
            disponibilidad.addProperty("finalPrevisto", rs.getDate("finalPrevisto").toString());
            disponibilidades.add(disponibilidad);
        }
        
        return disponibilidades;
    }
    
    /**
     * Devuelve una String JSON con los atributos de un empleado, o bien un mensaje de error.
     * @param login DNI del empleado
     * @param password Contraseña utilizada
     * @return JSON con atributos del empleado o mensaje de error
     */
    public static String consultaEmpleadoPorLoginYPassword(String login, String password) {
        JsonObject jo = new JsonObject();
        
        try {
            ConexionBD conn = conectarse();
            PreparedStatement pst = conn.prepareStatement(QUERY_LOGIN_PASS);
            pst.setString(1, login);
            pst.setString(2, password);
            ResultSet rs = conn.consulta(pst);
            if(rs.next()){
                jo.addProperty("dni", rs.getString("nif"));
                jo.addProperty("nombre", rs.getString("nombre"));
                jo.addProperty("apellidos", rs.getString("apellidos"));
                jo.addProperty("fechaInicio", rs.getDate("fechaInicioEnEmpresa").toString());
                jo.add("roles", obtenerRolesEmpleado(conn, login));
                jo.add("vinculaciones", obtenerVinculacionesEmpleado(conn, login));
                jo.add("disponibilidades", obtenerDisponibilidadesEmpleado(conn, login));
            } else {
                // COMENTAR CON YANIA SI SERÍA MEJOR UN MENSAJE UNIFICADO
                // PARA EVITAR ENUMERACIÓN DE DNIS
                
                // Comprueba si el NIF existe
                pst = conn.prepareStatement(QUERY_NIF);
                pst.setString(1, login);
                rs = conn.consulta(pst);
                if(rs.next()) {
                    // NIF existe -> Password incorrecta
                    jo.addProperty("error", CtrlVistaIdentificarse.ERROR_PASS_INCORRECTA);
                }else{
                    // NIF no existe
                    jo.addProperty("error", CtrlVistaIdentificarse.ERROR_DNI_NO_EXISTENTE);
                }
            }
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(FachadaPersistenciaEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            jo = new JsonObject(); // Borra posibles valores
            jo.addProperty("error", CtrlVistaIdentificarse.ERROR_INESPERADO);
        }
        
        return jo.toString();
    }
   
}
