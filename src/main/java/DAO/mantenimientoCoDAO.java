/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Supervisor;
import Model.mantenimientos;
import Util.DbUtil;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Labin
 */
public class mantenimientoCoDAO {

    private Connection connection;

    public mantenimientoCoDAO() throws SQLException, URISyntaxException {
        connection = DbUtil.getConnection();
    }

    public boolean addmantenimiento(mantenimientos mantenimiento) throws SQLException, URISyntaxException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "insert into supervisor (mantenimiento.ID,mantenimiento.IDACTIVO,mantenimiento.DESCRIPCION,mantenimiento.PIEZASCAMBIADAS) values (?, ?, ?, ? );";
        PreparedStatement preparedStmt = null;
        try { 
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, mantenimiento.getId());
            preparedStmt.setInt(2, mantenimiento.getIdAcivo());
            preparedStmt.setString(3, mantenimiento.getDescripcion());
            preparedStmt.setString(4, mantenimiento.getPiezasCambiadas());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean deletemantenimiento(int a) throws SQLException, URISyntaxException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "delete from mantenimiento where ID = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, a);
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    public ArrayList<mantenimientos> getAllMantenimiento() throws SQLException, URISyntaxException {
        ArrayList<mantenimientos> mantenimiento = null;
        boolean result = false;
        String query = "SELECT * FROM mantenimientosCo";
        Connection connection = DbUtil.getConnection();
        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            int id = 0;
            int idActivo=0; 
            String descripcion = null;
            String piezasCambiadas = null;
            
            while (rs.next()) {
                if (mantenimiento == null) {
                    mantenimiento = new ArrayList<mantenimientos>();
                }
                mantenimientos registro=new mantenimientos(id, idActivo, descripcion, piezasCambiadas);
                id = rs.getInt("id");
                registro.setId(id);

                idActivo = rs.getInt("idActivo");
                registro.setIdAcivo(idActivo);

                descripcion = rs.getString("descripcion");
                registro.setDescripcion(descripcion);

                piezasCambiadas = rs.getString("piezasCambiadas");
                registro.setPiezasCambiadas(piezasCambiadas);

                

                mantenimiento.add(registro);

            }
            if (mantenimiento != null) {
                for (int i = 0; i < mantenimiento.size(); i++) {
                    System.out.println(mantenimiento.get(i).getId() + " " + mantenimiento.get(i).getIdAcivo() + " " + mantenimiento.get(i).getDescripcion()+ " " + mantenimiento.get(i).getPiezasCambiadas());
                }
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Mantenimientos");
            e.printStackTrace();
        }

        return mantenimiento;

    }
}