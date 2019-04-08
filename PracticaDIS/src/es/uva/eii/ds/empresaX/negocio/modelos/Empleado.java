package es.uva.eii.ds.empresaX.negocio.modelos;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import java.time.LocalDate;
import java.util.TreeMap;

/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class Empleado {
    
    private String dni;
    private String nombre;
    private String apellidos;
    private LocalDate fechaInicioEnEmpresa;
    private TreeMap<LocalDate, Rol> rolesEnLaEmpresa;
    private TreeMap<LocalDate, VinculacionConLaEmpresa> estadoDeVinculacion;
    private TreeMap<LocalDate, Disponibilidad> estadoDeDisponibilidad;
    
    /**
     * Construye un objeto Empleado a partir de una cadena JSON.
     * 
     * Ejemplo de jsonString: 
     * { "dni"              : "12345678Z",
     *   "nombre"           : "Hermenegildo Manuel",
     *   "apellidos"        : "Ruipérez Núñez",
     *   "fechaInicio"      : "2014-02-25",
     *   "roles"            : [
     *      { "rol" : "DEPENDIENTE", "comienzo" : "2014-02-25" },
     *      { "rol" : "ENCARGADO"  , "comienzo" : "2015-04-14" }
     *   ],
     *   "vinculaciones"    : [
     *      { "vinculacion" : "CONTRATADO", "comienzo" : "2014-02-25" }
     *   ],
     *   "disponibilidades" : [
     *      { "disponibilidad" : "TRABAJANDO"  , "comienzo" : "2014-02-25" },
     *      { "disponibilidad" : "VACACIONES"  , "comienzo" : "2014-06-23", "finalPrevisto" : "2014-08-29" },
     *      { "disponibilidad" : "TRABAJANDO"  , "comienzo" : "2014-08-29" },
     *      { "disponibilidad" : "BAJATEMPORAL", "comienzo" : "2014-11-05", "finalPrevisto" : "2015-02-05" },
     *      { "disponibilidad" : "TRABAJANDO"  , "comienzo" : "2015-02-12" }
     *   ]
     * }
     * @param jsonString 
     */
    public Empleado(String jsonString) {
        try {
            JsonObject jo = new Gson().fromJson(jsonString, JsonObject.class);
            // NOMBRE, APELLIDOS Y DNI
            nombre = jo.get("nombre").getAsString();
            apellidos = jo.get("apellidos").getAsString();
            dni = jo.get("dni").getAsString();
            // FECHA DE INICIO
            String[] fechaI = jo.get("fechaInicio").getAsString().split("-");
            fechaInicioEnEmpresa = LocalDate.of(
                    Integer.valueOf(fechaI[0]), // YYYY
                    Integer.valueOf(fechaI[1]), // MM
                    Integer.valueOf(fechaI[2])  // DD
            );
            // ROLES
                // TODO
            // VINCULACIONES
                // TODO
            // DISPONIBILIDADES
                // TODO
        } catch(JsonSyntaxException | NumberFormatException e) {
            // Especificar excepciones
            System.out.println("[!] Excepción al crear Empleado:");
            e.printStackTrace();
        }
    }

    /**
     * Devuelve el DNI del empleado, que actúa como identificador único.
     * @return DNI del empleado
     */
    public String getDni() {
        return dni;
    }
    
    /**
     * Devuelve el nombre del empleado.
     * @return Nombre del empleado
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Devuelve los apellidos del empleado.
     * @return Apellidos del empleado
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Devuelve la fecha de inicio en la empresa.
     * @return Fecha de inicio en la empresa
     */
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
