package Model;

import java.util.ArrayList;

/**
 *
 * @author anfeg
 */
public class Prestamo {

    private int id_prestamo;
    private String fecha_entrada;
    private String fecha_salida;
    private String tipo;
    private String activo;
    private int id_solicitante;
    private int id_trabajador;

    public Prestamo(int id_prestamo, String fecha_entrada, String fecha_salida, String tipo, String activo, int id_solicitante, int id_trabajador) {
        this.id_prestamo = id_prestamo;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.tipo = tipo;
        this.activo = activo;
        this.id_solicitante = id_solicitante;
        this.id_trabajador = id_trabajador;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public String getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public int getId_solicitante() {
        return id_solicitante;
    }

    public void setId_solicitante(int id_solicitante) {
        this.id_solicitante = id_solicitante;
    }

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

   

}
