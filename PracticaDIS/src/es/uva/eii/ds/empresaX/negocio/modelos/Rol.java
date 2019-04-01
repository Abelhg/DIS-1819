package es.uva.eii.ds.empresaX.negocio.modelos;

public class Rol {

    private TipoRol tipo;
    
    public Rol(TipoRol tipo){
        this.tipo = tipo;
    }

    public TipoRol getTipo() {
        return tipo;
    }

    public void setTipo(TipoRol tipo) {
        this.tipo = tipo;
    }
    
}
