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
public class Solicitante extends Persona {

    private String escuela;
    private String tipo;

    public Solicitante(int id, String nombre, String apellido, String escuela, String tipo) {
        super(id, nombre, apellido);
        this.escuela = escuela;
        this.tipo = tipo;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
