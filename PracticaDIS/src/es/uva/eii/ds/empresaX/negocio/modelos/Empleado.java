package es.uva.eii.ds.empresaX.negocio.modelos;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.time.LocalDate;
import java.util.TreeMap;

public class Empleado {
    private String nombre;
    private String dni;
    private LocalDate fechaInicioEnEmpresa;
    private TreeMap<LocalDate, Rol> rolesEnLaEmpresa;
    private TreeMap<LocalDate, VinculacionConLaEmpresa> estadoDeVinculacion;
    private TreeMap<LocalDate, Disponibilidad> estadoDeDisponibilidad;
    
    /**
     * Construye un objeto Empleado a partir de una cadena JSON.
     * 
     * Ejemplo de jsonString: 
     * { "nombre"           : "Hermenegildo Ruipérez",
     *   "dni"              : "12345678Z",
     *   "fechaInicio"      : "25-02-2014",
     *   "roles"            : [
     *      { "rol" : "DEPENDIENTE", "comienzo" : "25-02-2014" },
     *      { "rol" : "ENCARGADO"  , "comienzo" : "14-04-2015" }
     *   ],
     *   "vinculaciones"    : [
     *      { "vinculacion" : "CONTRATADO", "comienzo" : "25-02-2014" }
     *   ],
     *   "disponibilidades" : [
     *      { "disponibilidad" : "TRABAJANDO"  , "comienzo" : "25-02-2014" },
     *      { "disponibilidad" : "VACACIONES"  , "comienzo" : "23-06-2014" },
     *      { "disponibilidad" : "TRABAJANDO"  , "comienzo" : "29-08-2014" },
     *      { "disponibilidad" : "BAJATEMPORAL", "comienzo" : "05-11-2014" },
     *      { "disponibilidad" : "TRABAJANDO"  , "comienzo" : "12-02-2015" }
     *   ]
     * }
     * @param jsonString 
     */
    public Empleado(String jsonString) {
        try {
            JsonObject jo = new Gson().fromJson(jsonString, JsonObject.class);
            // NOMBRE Y DNI
            nombre = jo.get("nombre").getAsString();
            dni = jo.get("dni").getAsString();
            // FECHA DE INICIO
            String[] fechaI = jo.get("fechaInicio").getAsString().split("-");
            fechaInicioEnEmpresa = LocalDate.of(
                    Integer.valueOf(fechaI[0]),
                    Integer.valueOf(fechaI[1]),
                    Integer.valueOf(fechaI[2])
            );
            // ROLES
            
            // VINCULACIONES
            
            // DISPONIBILIDADES
        } catch(Exception e) {
            // Especificar excepciones
            System.out.println("[!] Excepción al crear Empleado:");
            e.printStackTrace();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public LocalDate getFechaInicioEnEmpresa() {
        return fechaInicioEnEmpresa;
    }
    
    /**
     * Devuelve true si el empleado está actualmente activo, false si no.
     * @return true si está activo
     */
    public boolean estaActivo() {
        boolean activoDisponible  = estadoDeDisponibilidad.lastEntry().
                                    getValue().estaEnActivo();
        boolean activoVinculacion = estadoDeVinculacion.lastEntry().
                                    getValue().estaEnActivo();
        
        return activoDisponible && activoVinculacion;
    }
    
    /**
     * Devuelve el rol actual del empleado (el último).
     * @return Rol actual
     */
    public Rol obtenerRolActual() {
        return rolesEnLaEmpresa.lastEntry().getValue();
    }
    
}
