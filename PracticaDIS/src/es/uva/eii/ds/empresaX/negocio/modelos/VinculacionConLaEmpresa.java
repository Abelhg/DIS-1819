/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.ds.empresaX.negocio.modelos;

import java.time.LocalDate;

/**
 *
 * @author daniel
 */
public class VinculacionConLaEmpresa {
    
    private TipoVinculacion tipo;
    private LocalDate fecha;

    public VinculacionConLaEmpresa(LocalDate fecha,TipoVinculacion tipo) {
        this.fecha = fecha;
        this.tipo = tipo;
    }

    public TipoVinculacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoVinculacion tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    public boolean estaEnActivo(){
        if(tipo.toString().equals(tipo.CONTRATADO)){
            return true;
        }else{
            return false;
        }
                
    }
}
