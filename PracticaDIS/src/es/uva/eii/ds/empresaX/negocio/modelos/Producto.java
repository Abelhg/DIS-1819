/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uva.eii.ds.empresaX.negocio.modelos;

/**
 *
 * @author daniel
 */
public abstract class Producto {

    private String codigo;
    private String nombre;
    private String descripcion;
    private int existencias;
    private int cantidadMinimaEnStock;

    
    public Producto(String jsonString) {
        // TODO
    }
    
    public Producto(String codigo, String nombre, String descripcion, int existencias, int cantidadMinimaEnStock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.existencias = existencias;
        this.cantidadMinimaEnStock = cantidadMinimaEnStock;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public int getCantidadMinimaEnStock() {
        return cantidadMinimaEnStock;
    }

    public void setCantidadMinimaEnStock(int cantidadMinimaEnStock) {
        this.cantidadMinimaEnStock = cantidadMinimaEnStock;
    }
    
    
    
}
