package es.uva.eii.ds.empresaX.negocio.controladoresCasoUso;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import es.uva.eii.ds.empresaX.negocio.modelos.Empleado;
import es.uva.eii.ds.empresaX.negocio.modelos.Sesion;
import es.uva.eii.ds.empresaX.persistencia.FachadaPersistenciaEmpleado;
import es.uva.eii.ds.empresaX.servicioscomunes.MessageException;

public class ControladorCUIdentificarse {
    
    /**
     * Identifica un empleado con el dni y password proporcionados. Si se identifica
     * con éxito, devuelve null. Si no, devuelve el mensaje de error correspondiente.
     * 
     * @param dni DNI del empleado
     * @param password Password del empleado
     * @return Mensaje de error (null si no hay)
     * @throws es.uva.eii.ds.empresaX.servicioscomunes.MessageException Si ha ocurrido un error
     */
    public String identificarEmpleado(String dni, String password) throws MessageException {
        String res = null;
        String resultado = FachadaPersistenciaEmpleado.consultaEmpleadoPorLoginYPassword(dni, password);
        JsonObject json = new Gson().fromJson(resultado, JsonObject.class);
        if(json.has("error")) {
            res = json.get("error").getAsString();
        } else {
            // Crea el Empleado y lo asigna a la sesión
            Sesion.getInstanciaSingleton().setEmpleado(new Empleado(resultado));
        }
        
        return res;
    }
    
    
    /*****     SINGLETON     *****/
    /**
     * Devuelve una instancia única para la clase.
     * @return Instancia única
     */
    private static ControladorCUIdentificarse instancia;
    public static ControladorCUIdentificarse getInstanciaSingleton() {
        if(instancia == null){
            instancia = new ControladorCUIdentificarse();
            }
        
        return instancia;
    }
    
}
