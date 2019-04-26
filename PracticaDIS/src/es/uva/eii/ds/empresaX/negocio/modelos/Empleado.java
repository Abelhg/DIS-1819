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
    
    public static final String JSON_DNI = "dni";
    public static final String JSON_NOMBRE = "nombre";
    public static final String JSON_APELLIDOS = "apellidos";
    public static final String JSON_FECHA_INICIO = "fechaInicio";
    public static final String JSON_COMIENZO = "comienzo";
    public static final String JSON_FINAL_PREVISTO = "finalPrevisto";
    public static final String JSON_ROLES = "roles";
    public static final String JSON_ROL = "rol";
    public static final String JSON_VINCULACIONES = "vinculaciones";
    public static final String JSON_VINCULACION = "vinculacion";
    public static final String JSON_DISPONIBILIDADES = "disponibilidades";
    public static final String JSON_DISPONIBILIDAD = "disponibilidad";

    public static final String JSON_ERROR = "error";
    
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
     *      { "rol" : "Dependiente", "comienzo" : "2014-02-25" },
     *      { "rol" : "Supervisor"  , "comienzo" : "2015-04-14" }
     *   ],
     *   "vinculaciones"    : [
     *      { "vinculacion" : "Contratado", "comienzo" : "2014-02-25" }
     *   ],
     *   "disponibilidades" : [
     *      { "disponibilidad" : "Trabajando"  , "comienzo" : "2014-02-25" },
     *      { "disponibilidad" : "Vacaciones"  , "comienzo" : "2014-06-23", "finalPrevisto" : "2014-08-29" },
     *      { "disponibilidad" : "Trabajando"  , "comienzo" : "2014-08-29" },
     *      { "disponibilidad" : "BajaTemporal", "comienzo" : "2014-11-05", "finalPrevisto" : "2015-02-05" },
     *      { "disponibilidad" : "Trabajando"  , "comienzo" : "2015-02-12" }
     *   ]
     * }
     * @param jsonString 
     */
    public Empleado(String jsonString) {
        try {
            JsonObject jo = new Gson().fromJson(jsonString, JsonObject.class);
            // NOMBRE, APELLIDOS Y DNI
            nombre = jo.get(JSON_NOMBRE).getAsString();
            apellidos = jo.get(JSON_APELLIDOS).getAsString();
            dni = jo.get(JSON_DNI).getAsString();
            // FECHA DE INICIO
            String[] fechaI = jo.get(JSON_FECHA_INICIO).getAsString().split("-");
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
