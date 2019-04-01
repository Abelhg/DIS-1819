package es.uva.eii.ds.empresaX.negocio.modelos;

public class VinculacionConLaEmpresa {
    
    private TipoVinculacion tipo;

    public VinculacionConLaEmpresa(TipoVinculacion tipo) {
        this.tipo = tipo;
    }

    public TipoVinculacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoVinculacion tipo) {
        this.tipo = tipo;
    }
    
    public boolean estaEnActivo(){
        boolean activo = false;
        
        switch(tipo) {
            case CONTRATADO:
                activo = true;
                break;
            case DESPEDIDO:
            case ENERTE:
            default:
                activo = false;
                break;
        }
        
        return activo;
    }
}
