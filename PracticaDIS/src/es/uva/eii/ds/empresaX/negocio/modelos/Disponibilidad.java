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
public class Disponibilidad {
    
    private LocalDate comienzo;
    private TipoDisponibilidad tipo;

    public Disponibilidad(LocalDate comienzo, TipoDisponibilidad tipo) {
        this.comienzo = comienzo;
        this.tipo = tipo;
    }

    public LocalDate getComienzo() {
        return comienzo;
    }

    public void setComienzo(LocalDate comienzo) {
        this.comienzo = comienzo;
    }

    public TipoDisponibilidad getTipo() {
        return tipo;
    }

    public void setTipo(TipoDisponibilidad tipo) {
        this.tipo = tipo;
    }
    
    public boolean estaEnActivo(){
        if(tipo.toString().equals(tipo.TRABAJANDO.toString())){
           return true; 
        }else{
            return false;
        }
    }
    
}
