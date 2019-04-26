package es.uva.eii.ds.empresaX.negocio.controladoresCasoUso;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import es.uva.eii.ds.empresaX.negocio.modelos.Empleado;
import es.uva.eii.ds.empresaX.persistencia.FachadaPersistenciaEmpleado;

public class ControladorCUIdentificarse {
    
    /**
     * Devuelve al empleado con el dni y password asociados. Devuelve null
     * si no existe.
     * @param dni DNI del empleado
     * @param password Password del empleado
     * @return Empleado o null
     */
    public Empleado identificarEmpleado(String dni, String password) {
        Empleado res = null;
        String resultado = FachadaPersistenciaEmpleado.consultaEmpleadoPorLoginYPassword(dni, password);
        JsonObject json = new Gson().fromJson(resultado, JsonObject.class);
        if(json.has("error")) {
            // Ha ocurrido un error, ¿cómo se lo notifica al controlador de la vista?
            // Solución simple: devolver null y que lo gestione el controlador,
            // pero ¿y si yo quiero devolver un mensaje específico?
            System.err.println("\n[!] " + json.get("error"));
        } else {
            // Crea el Empleado
            res = new Empleado(resultado);
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
