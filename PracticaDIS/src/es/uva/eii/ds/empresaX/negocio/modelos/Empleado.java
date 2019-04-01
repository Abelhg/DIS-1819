package es.uva.eii.ds.empresaX.negocio.modelos;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.TreeMap;

public class Empleado {
    private String nombre;
    private String dni;
    private LocalDate fechaInicioEnEmpresa;
    private TreeMap<LocalDate, TipoRol> rolesEnLaEmpresa;
    private TreeMap<LocalDate, VinculacionConLaEmpresa> estadoDeVinculacion;
    private TreeMap<LocalDate, Disponibilidad> estadoDeDisponibilidad;
    
    /**
     * Ejemplo de jsonString: 
     * { "nombre"        : "Hermenegildo Ruipérez",
     *   "dni"           : "12345678Z",
     *   "fechaInicio"   : "01-04-2019",
     *   "roles"         : // TODO  ,
     *   "vinculaciones" : // TODO  ,
     *   "estados"       : // TODO  ,
     * }
     * @param jsonString 
     */
    public Empleado(String jsonString) {
        try {
            JsonObject jo = new Gson().fromJson(jsonString, JsonObject.class);
            nombre = jo.get("nombre").getAsString();
            dni = jo.get("dni").getAsString();
            String[] fechaI = jo.get("fechaInicio").getAsString().split("-");
            fechaInicioEnEmpresa = LocalDate.of(
                    Integer.valueOf(fechaI[0]),
                    Integer.valueOf(fechaI[1]),
                    Integer.valueOf(fechaI[2])
            );
            
            // TODO Roles en la empresa
        } catch(Exception e) {
            // Especificar excepciones
            System.out.println("[!] Excepción al crear Empleado:");
            e.printStackTrace();
        }
    }
    
    public boolean estaActivo() {
        boolean activoDisponible  = estadoDeDisponibilidad.lastEntry().
                                    getValue().estaEnActivo();
        boolean activoVinculacion = estadoDeVinculacion.lastEntry().
                                    getValue().estaEnActivo();
        
        return activoDisponible && activoVinculacion;
    }
    
    public TipoRol obtenerRolActual() {
        return rolesEnLaEmpresa.lastEntry().getValue();
    }
    
}
