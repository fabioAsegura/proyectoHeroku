/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Labin
 */
public abstract class Trabajador extends Persona {

    protected String fechaEntrada;

    public Trabajador(int id, String nombre, String apellido, String fechaEntrada) {
        super(id, nombre, apellido);
        this.fechaEntrada = fechaEntrada;
    }

    public Trabajador() {
        super();
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

}
