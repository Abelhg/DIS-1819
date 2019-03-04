/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDateTime;

/**
 *
 * @author daniel
 */
public class Momento {
    
    private int dia;
    private int mes;
    private int anyo;
    private int hora;
    private int min;
    private int seg;
    
    public Momento(){
    }

    public Momento(int dia, int mes, int anyo, int hora, int min, int seg) {
        this.dia = dia;
        this.mes = mes;
        this.anyo = anyo;
        this.hora = hora;
        this.min = min;
        this.seg = seg;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSeg() {
        return seg;
    }

    public void setSeg(int seg) {
        this.seg = seg;
    }
    
    public Momento getNow(){
        LocalDateTime now = LocalDateTime.now();
        return new Momento(now.getYear(),now.getMonthValue(),now.getDayOfMonth(),now.getHour(),now.getMinute(),now.getSecond());
    }
    
}
