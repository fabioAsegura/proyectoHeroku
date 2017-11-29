/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author User
 */
public class mantenimientos {

    public mantenimientos(int id, int idAcivo, String descripcion, String piezasCambiadas) {
        this.id = id;
        this.idAcivo = idAcivo;
        this.descripcion = descripcion;
        this.piezasCambiadas = piezasCambiadas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAcivo() {
        return idAcivo;
    }

    public void setIdAcivo(int idAcivo) {
        this.idAcivo = idAcivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPiezasCambiadas() {
        return piezasCambiadas;
    }

    public void setPiezasCambiadas(String piezasCambiadas) {
        this.piezasCambiadas = piezasCambiadas;
    }
    
   private int id;
   private int idAcivo;
   private String descripcion;
   private String piezasCambiadas;
}
