/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author anfeg
 */
public class Mantenimiento {

    private int id_activo;
    private String tipo;
    private String descripcion;
    private String materiales;

    public Mantenimiento(int id_activo, String tipo, String descripcion, String materiales) {
        this.id_activo = id_activo;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.materiales = materiales;
    }

    public Mantenimiento() {
    }

    public int getId_activo() {
        return id_activo;
    }

    public void setId_activo(int id_activo) {
        this.id_activo = id_activo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMateriales() {
        return materiales;
    }

    public void setMateriales(String materiales) {
        this.materiales = materiales;
    }

    @Override
    public String toString() {
        return "Mantenimiento{" + "id_activo=" + id_activo + ", tipo=" + tipo + ", descripcion=" + descripcion + ", materiales=" + materiales + '}';
    }

}
