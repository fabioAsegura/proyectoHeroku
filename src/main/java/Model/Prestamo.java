package Model;

import java.util.ArrayList;

/**
 *
 * @author anfeg
 */
public class Prestamo {

    private int id_prestamo;
    private int id_solicitante;
    private int id_trabajador;
    private ArrayList<Integer> activo;
    private String tipo;
    private String fechaEntrada;
    private String fechaSalida;

    public Prestamo(int id_prestamo, int id_solicitante, int id_trabajador, ArrayList<Integer> activo, String tipo, String fechaEntrada, String fechaSalida) {
        this.id_prestamo = id_prestamo;
        this.id_solicitante = id_solicitante;
        this.id_trabajador = id_trabajador;
        this.activo = activo;
        this.tipo = tipo;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
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

    public ArrayList<Integer> getActivo() {
        return activo;
    }

    public void setActivo(ArrayList<Integer> activo) {
        this.activo = activo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

}
