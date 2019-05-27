package es.uva.eii.ds.empresaX.persistencia;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import es.uva.eii.ds.empresaX.servicioscomunes.JSONHelper;
import es.uva.eii.ds.empresaX.servicioscomunes.MessageException;
import java.sql.Connection;
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
    
    private static final String QUERY_NIF = "SELECT * FROM Empleado WHERE nif = (?)";
    private static final String QUERY_NIF_PASS = "SELECT * FROM Empleado WHERE nif = (?) AND password = (?)";
    private static final String QUERY_ROLES = "SELECT * FROM RolesEnEmpresa WHERE empleado = (?)";
    private static final String QUERY_NOMBRE_TIPO_1 = "SELECT nombreTipo FROM ";
    private static final String QUERY_NOMBRE_TIPO_2 = " WHERE idTipo = (?)";
    private static final String QUERY_VINCULACIONES = "SELECT * FROM VinculacionConLaEmpresa WHERE empleado = (?)";
    private static final String QUERY_DISPONIBILIDADES = "SELECT * FROM DisponibilidadEmpleado WHERE empleado = (?)";
    
    
        // NOMBRES BD
    private static final String TIPOS_ROL = "TipoDeRol";
    private static final String TIPOS_VINCULACION = "TipoDeVinculacion";
    private static final String TIPOS_DISPONIBILIDAD = "TipoDeDisponibilidad";
    
    private static final String NOMBRE_TIPO = "NombreTipo";
    
    // EMPLEADO
    private static final String EMPL_NIF = "nif";
    private static final String EMPL_NOMBRE = "nombre";
    private static final String EMPL_APELLIDOS = "apellidos";
    private static final String EMPL_FECHA_INICIO = "fechaInicioEnEmpresa";
    
    // ROLES
    private static final String ROL_COMIENZO = "ComienzoEnRol";
    private static final String ROL_ROL = "Rol";
    
    // VINCULACIONES
    private static final String VINC_INICIO = "inicio";
    private static final String VINC_VINCULO = "Vinculo";
    
    // DISPONIBILIDADES
    private static final String DISP_COMIENZO = "Comienzo";
    private static final String DISP_FINAL = "FinalPrevisto";
    private static final String DISP_DISPONIBILIDAD = "Disponibilidad";
    
    private static ConexionBD conectarse() throws ClassNotFoundException, SQLException {
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
    public static String obtenerNombreTipo(ConexionBD conn, String nombreTabla, int idTipo) throws SQLException {
        String res = "DESCONOCIDO";
        
        PreparedStatement pst = conn.prepareStatement(QUERY_NOMBRE_TIPO_1 + nombreTabla + QUERY_NOMBRE_TIPO_2);
        pst.setInt(1, idTipo);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            res = rs.getString(NOMBRE_TIPO);
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
    public static JsonArray obtenerRolesEmpleado(ConexionBD conn, String dniEmpleado) throws SQLException {
        JsonArray roles = new JsonArray();
        
        PreparedStatement pst = conn.prepareStatement(QUERY_ROLES);
        pst.setString(1, dniEmpleado);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            JsonObject rol = new JsonObject();
            rol.addProperty(JSONHelper.JSON_COMIENZO, rs.getDate(ROL_COMIENZO).toString());
            rol.addProperty(JSONHelper.JSON_ROL, obtenerNombreTipo(conn, TIPOS_ROL, rs.getInt(ROL_ROL)));
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
    public static JsonArray obtenerVinculacionesEmpleado(ConexionBD conn, String dniEmpleado) throws SQLException {
        JsonArray vinculaciones = new JsonArray();
        
        PreparedStatement pst = conn.prepareStatement(QUERY_VINCULACIONES);
        pst.setString(1, dniEmpleado);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            JsonObject vinculacion = new JsonObject();
            vinculacion.addProperty(JSONHelper.JSON_COMIENZO, rs.getDate(VINC_INICIO).toString());
            vinculacion.addProperty(JSONHelper.JSON_VINCULACION, obtenerNombreTipo(conn, TIPOS_VINCULACION, rs.getInt(VINC_VINCULO)));
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
    public static JsonArray obtenerDisponibilidadesEmpleado(ConexionBD conn, String dniEmpleado) throws SQLException {
        JsonArray disponibilidades = new JsonArray();
        
        PreparedStatement pst = conn.prepareStatement(QUERY_DISPONIBILIDADES);
        pst.setString(1, dniEmpleado);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            JsonObject disponibilidad = new JsonObject();
            disponibilidad.addProperty(JSONHelper.JSON_COMIENZO, rs.getDate(DISP_COMIENZO).toString());
            if(rs.getDate(DISP_FINAL) != null) {
                // Puede ser null
                disponibilidad.addProperty(JSONHelper.JSON_FINAL_PREVISTO, rs.getDate(DISP_FINAL).toString());
            }
            disponibilidad.addProperty(JSONHelper.JSON_DISPONIBILIDAD, obtenerNombreTipo(conn, TIPOS_DISPONIBILIDAD, rs.getInt(DISP_DISPONIBILIDAD)));
            disponibilidades.add(disponibilidad);
        }
        
        return disponibilidades;
    }
    
    /**
     * Devuelve una String JSON con los atributos de un empleado, o bien un mensaje de error.
     * @param nif DNI del empleado
     * @param password Contraseña utilizada
     * @return JSON con atributos del empleado
     * @throws es.uva.eii.ds.empresaX.servicioscomunes.MessageException Si ha ocurrido un error inesperado al hacer la consulta
     */
    public static String consultaEmpleadoPorLoginYPassword(String nif, String password) throws MessageException {
        JsonObject jo = new JsonObject();
        
        try {
            ConexionBD conn = conectarse();
            // Ejecuta la selección
            PreparedStatement pst = conn.prepareStatement(QUERY_NIF_PASS);
            pst.setString(1, nif);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                // Credenciales válidas
                jo.addProperty(JSONHelper.JSON_DNI, rs.getString(EMPL_NIF));
                jo.addProperty(JSONHelper.JSON_NOMBRE, rs.getString(EMPL_NOMBRE));
                jo.addProperty(JSONHelper.JSON_APELLIDOS, rs.getString(EMPL_APELLIDOS));
                jo.addProperty(JSONHelper.JSON_FECHA_INICIO, rs.getDate(EMPL_FECHA_INICIO).toString());
                jo.add(JSONHelper.JSON_ROLES, obtenerRolesEmpleado(conn, nif));
                jo.add(JSONHelper.JSON_VINCULACIONES, obtenerVinculacionesEmpleado(conn, nif));
                jo.add(JSONHelper.JSON_DISPONIBILIDADES, obtenerDisponibilidadesEmpleado(conn, nif));
            } else {
                // Credenciales inválidas
                throw new MessageException("Credenciales inválidas");
            }
        } catch(SQLException ex){
            Logger.getLogger(FachadaPersistenciaEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            throw new MessageException("Error inesperado");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FachadaPersistenciaEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jo.toString();
    }
   
}
