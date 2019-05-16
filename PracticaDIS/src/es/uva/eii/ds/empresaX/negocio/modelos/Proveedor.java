package es.uva.eii.ds.empresaX.negocio.modelos;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Proveedor {
    // JSON
    public static String JSON_NOMBRE = "nombre";
    public static String JSON_TELEFONO = "telefono";
    public static String JSON_EMAIL = "email";
    
    // ATRIBUTOS
    private final String nombre;
    private final String telefono;
    private final String email;

    /**
     * Construye e inicializa un proveedor a partir de una string JSON.
     * @param jsonProveedor JSON de proveedor
     */
    public Proveedor(String jsonProveedor) {
        JsonObject jo = new Gson().fromJson(jsonProveedor, JsonObject.class);
        nombre = jo.get(JSON_NOMBRE).getAsString();
        telefono = jo.get(JSON_TELEFONO).getAsString();
        email = jo.get(JSON_EMAIL).getAsString();
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }
    
}
