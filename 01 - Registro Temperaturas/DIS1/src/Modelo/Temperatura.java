/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author daniel
 */
public class Temperatura {
    
    private float valor;
    private Unidad tipo;
    
    public Temperatura(){
        
    }

    public Temperatura(float valor, Unidad tipo) {
        this.valor = valor;
        this.tipo = tipo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Unidad getTipo() {
        return tipo;
    }

    public void setTipo(Unidad tipo) {
        this.tipo = tipo;
    }
    
    public boolean comprobarValorCorrecto(){
        
        switch(this.tipo){
            
            case CELSIUS:
                return (valor >= -273) ? true : false;
            case FARENHEIT:
                return (valor >= -459) ? true : false;
            case KELVIN:
                return (valor >= 0) ? true : false;
            default:
                return false;
        }
        
    }
    
    public Temperatura crearNuevaTemperatura(float temp,Unidad unidad){
        
        return new Temperatura(temp,unidad);
        
    }
    
}
