package es.uva.eii.ds.empresaX.negocio.modelos;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.sql.Date;
import java.time.LocalDate;

public final class Factura {
    
    // JSON
    public static final String JSON_FECHA_EMISION = "fechaEmision";
    public static final String JSON_IMPORTE = "importe";
    public static final String JSON_CUENTA_BANCARIA = "cuentaBancaria";
    public static final String JSON_PEDIDO = "pedido";
    
    private final LocalDate fechaEmision;
    private final double importe;
    private final String cuentaBancaria;
    private final PedidoAProveedor pedido;
    
    /**
     * Construye e inicializa una factura a partir de un JSON.
     * @param jsonFactura 
     */
    public Factura(String jsonFactura) {
        JsonObject jo = new Gson().fromJson(jsonFactura, JsonObject.class);
        fechaEmision = Date.valueOf(jo.get(JSON_FECHA_EMISION).getAsString()).toLocalDate();
        importe = jo.get(JSON_IMPORTE).getAsDouble();
        cuentaBancaria = jo.get(JSON_CUENTA_BANCARIA).getAsString();
        JsonElement get = jo.get(JSON_PEDIDO);
        pedido = new PedidoAProveedor(jo.get(JSON_PEDIDO).toString());
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public double getImporte() {
        return importe;
    }

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    public PedidoAProveedor getPedido() {
        return pedido;
    }
   
}
