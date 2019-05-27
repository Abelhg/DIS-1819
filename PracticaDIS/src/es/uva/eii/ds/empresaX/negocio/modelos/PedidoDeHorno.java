package es.uva.eii.ds.empresaX.negocio.modelos;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import es.uva.eii.ds.empresaX.servicioscomunes.JSONHelper;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.TreeMap;

/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class PedidoDeHorno {
    private int numeroDePedido;
    private LocalDate fechaEnLaQueSeQuiere;
    private Cliente cliente;
    private Empleado dependiente;
    private TreeMap<LocalDateTime, EstadoPedido> estadosPedido;

    /**
     * Construye e inicializa un Pedido de Horno desde una string JSON.
     * @param jsonString String JSON
     */
    public PedidoDeHorno(String jsonString) {
        try {
            JsonObject jo = new Gson().fromJson(jsonString, JsonObject.class);
            
            numeroDePedido = jo.get(JSONHelper.JSON_NUM_PEDIDO).getAsInt();
            // FECHA DESEADA
            String[] fechaD = jo.get(JSONHelper.JSON_FECHA_DESEADA).getAsString().split("-");
            fechaEnLaQueSeQuiere = LocalDate.of(
                    Integer.valueOf(fechaD[0]), // YYYY
                    Integer.valueOf(fechaD[1]), // MM
                    Integer.valueOf(fechaD[2])  // DD
            );
            
            cliente = new Cliente(jo.get(JSONHelper.JSON_CLIENTE).toString());
            dependiente = new Empleado(jo.get(JSONHelper.JSON_DEPENDIENTE).toString());
            configuraEstados(jo);
        } catch(JsonSyntaxException | NumberFormatException e) {
            // Especificar excepciones
            System.out.println("[!] Excepción al crear Empleado:");
            e.printStackTrace();
        }
    }
    
    /**
     * Obtiene los roles y los añade a la lista.
     * @param jo Objeto JSON
     */
    private void configuraEstados(JsonObject jo) {
        estadosPedido = new TreeMap<>();
        JsonArray jRoles = jo.getAsJsonArray(JSONHelper.JSON_ROLES);
        for(JsonElement jr : jRoles) {
            JsonObject jEstado = new Gson().fromJson(jr.toString(), JsonObject.class);
            LocalDateTime momento = Timestamp.valueOf(jEstado.get(JSONHelper.JSON_COMIENZO).getAsString()).toLocalDateTime();
            EstadoPedido estado = new EstadoPedido(TipoEstadoPedido.valueOf(jEstado.get(JSONHelper.JSON_ESTADO).getAsString()));
            estadosPedido.put(momento, estado);
        }
    }

    public int getNumeroDePedido() {
        return numeroDePedido;
    }

    public LocalDate getFechaEnLaQueSeQuiere() {
        return fechaEnLaQueSeQuiere;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Empleado getDependiente() {
        return dependiente;
    }

    public EstadoPedido getUltimoEstado() {
        return estadosPedido.lastEntry().getValue();
    }
    
}
