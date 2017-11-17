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
    private String activo1;
    private String activo2;
    private String activo3;
    private String activo4;
    private String activo5;
    private int id_solicitante;
    private int id_trabajador;

    public Prestamo(int id_prestamo, String fecha_entrada, String fecha_salida,String tipo ,String activo1, String activo2, String activo3, String activo4, String activo5, int id_solicitante, int id_trabajador) {
        this.id_prestamo = id_prestamo;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.tipo = tipo;
        this.activo1 = activo1;
        this.activo2 = activo2;
        this.activo3 = activo3;
        this.activo4 = activo4;
        this.activo5 = activo5;
        this.id_solicitante = id_solicitante;
        this.id_trabajador = id_trabajador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public String getActivo1() {
        return activo1;
    }

    public void setActivo1(String activo1) {
        this.activo1 = activo1;
    }

    public String getActivo2() {
        return activo2;
    }

    public void setActivo2(String activo2) {
        this.activo2 = activo2;
    }

    public String getActivo3() {
        return activo3;
    }

    public void setActivo3(String activo3) {
        this.activo3 = activo3;
    }

    public String getActivo4() {
        return activo4;
    }

    public void setActivo4(String activo4) {
        this.activo4 = activo4;
    }

    public String getActivo5() {
        return activo5;
    }

    public void setActivo5(String activo5) {
        this.activo5 = activo5;
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
