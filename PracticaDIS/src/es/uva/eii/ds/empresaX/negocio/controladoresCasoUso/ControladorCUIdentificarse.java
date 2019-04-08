package es.uva.eii.ds.empresaX.negocio.controladoresCasoUso;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import es.uva.eii.ds.empresaX.negocio.modelos.Empleado;
import es.uva.eii.ds.empresaX.persistencia.FachadaPersistenciaEmpleado;

public class ControladorCUIdentificarse {
    
    public static Empleado identificarEmpleado(String dni, String password) {
        Empleado res = null;
        String jsonEmpleado = FachadaPersistenciaEmpleado.consultaEmpleadoPorLoginYPassword(dni, password);
        JsonObject jo = new Gson().fromJson(jsonEmpleado, JsonObject.class);
        if(jo.has("error")) {
            // Ha ocurrido un error, ¿cómo se lo notifica al controlador de la vista?
                // TODO
        } else {
            // Crea el Empleado
            res = new Empleado(jsonEmpleado);
        }
        
        return res;
    }
    
}
