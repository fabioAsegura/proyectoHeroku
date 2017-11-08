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
public class Activo {

    private int id_activo;
    private String tipo;
    private String fabricante;
    private String fecha_compra;
    private String ultimo_mantenimiento;
    private String estado;
    private String prestado;
    private int calificacion;

    public Activo(int id_activo, String tipo, String fabricante, String fecha_compra, String ultimo_mantenimiento, String estado, String prestado, int calificacion) {
        this.id_activo = id_activo;
        this.tipo = tipo;
        this.fabricante = fabricante;
        this.fecha_compra = fecha_compra;
        this.ultimo_mantenimiento = ultimo_mantenimiento;
        this.estado = estado;
        this.prestado = prestado;
        this.calificacion = calificacion;
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

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public String getUltimo_mantenimiento() {
        return ultimo_mantenimiento;
    }

    public void setUltimo_mantenimiento(String ultimo_mantenimiento) {
        this.ultimo_mantenimiento = ultimo_mantenimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPrestado() {
        return prestado;
    }

    public void setPrestado(String prestado) {
        this.prestado = prestado;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

}
