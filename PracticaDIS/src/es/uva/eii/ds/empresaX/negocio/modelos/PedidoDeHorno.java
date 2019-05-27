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
    private TreeMap<LocalDateTime, OperacionPedido> operacionesPedido;

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
            configuraOperacionesPedido(jo);
        } catch(JsonSyntaxException | NumberFormatException e) {
            // Especificar excepciones
            System.out.println("[!] Excepción al crear Empleado:");
            e.printStackTrace();
            throw new IllegalArgumentException("[!] Excepción al crear Empleado: " + e.getMessage());
        }
    }
    
    /**
     * Obtiene las operaciones y las añade al árbol.
     * @param jo Objeto JSON
     */
    private void configuraOperacionesPedido(JsonObject jo) {
        operacionesPedido = new TreeMap<>();
        JsonArray jOperaciones = jo.getAsJsonArray(JSONHelper.JSON_OPERACIONES);
        for(JsonElement jop : jOperaciones) {
            JsonObject jOperacion = new Gson().fromJson(jop.toString(), JsonObject.class);
            // Momento de generación de la operación
            LocalDateTime momento = Timestamp.valueOf(jOperacion.get(JSONHelper.JSON_MOMENTO).getAsString()).toLocalDateTime();
            // Estado de la operación
            String estado = jOperacion.get(JSONHelper.JSON_ESTADO).getAsString();
            // Empleado que realizó la operación
            Empleado empleado = new Empleado(jOperacion.get(JSONHelper.JSON_EMPLEADO).toString());
            operacionesPedido.put(momento, new OperacionPedido(TipoEstadoPedido.valueOf(estado), empleado));
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

    public OperacionPedido getUltimoEstado() {
        return operacionesPedido.lastEntry().getValue();
    }
    
}
