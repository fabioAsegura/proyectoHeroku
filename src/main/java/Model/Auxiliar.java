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
public class Auxiliar extends Trabajador {

    private String turno;
    private int id_supervisor;

    public Auxiliar(int id, String nombre, String apellido, String fechaEntrada, String turno, int id_supervisor) {
        super(id, nombre, apellido, fechaEntrada);
        this.turno = turno;
        this.id_supervisor = id_supervisor;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getId_supervisor() {
        return id_supervisor;
    }

    public void setId_supervisor(int id_supervisor) {
        this.id_supervisor = id_supervisor;
    }

}
