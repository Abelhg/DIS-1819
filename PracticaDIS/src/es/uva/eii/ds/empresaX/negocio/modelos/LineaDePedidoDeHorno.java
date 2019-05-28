package es.uva.eii.ds.empresaX.negocio.modelos;


public class LineaDePedidoDeHorno {
    
    private final int cantidad;
    private final Producto productoPedido;

    public LineaDePedidoDeHorno(int cantidad, Producto productoPedido) {
        this.cantidad = cantidad;
        this.productoPedido = productoPedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Producto getProductoPedido() {
        return productoPedido;
    }
    
}
