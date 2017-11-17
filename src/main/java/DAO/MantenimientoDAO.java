/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Mantenimiento;
import Util.DbUtil;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Labin
 */
public class MantenimientoDAO {

    private Connection connection;

    public MantenimientoDAO() throws SQLException, URISyntaxException {
        connection = DbUtil.getConnection();
    }

    public boolean addMantenimiento(Mantenimiento mantenimiento) throws SQLException, URISyntaxException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "insert into mantenimiento (id_activo,tipo,descripcion,materiales) values (?,?,?,? );";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, mantenimiento.getId_activo());
            preparedStmt.setString(2, mantenimiento.getTipo());
            preparedStmt.setString(3, mantenimiento.getDescripcion());
            preparedStmt.setString(4, mantenimiento.getMateriales());
           

            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean deleteMantenimiento(int a) throws SQLException, URISyntaxException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "delete from mantenimiento  where id_activo= ?";
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

    public ArrayList<Mantenimiento> getAllMantenimiento() throws SQLException, URISyntaxException {
        ArrayList<Mantenimiento> mantenimiento = null;
        boolean result = false;
        String query = "SELECT * FROM mantenimiento";
        Connection connection = DbUtil.getConnection();
        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            int id = 0;
            String tipo = null;
            String descripcion = null;
            String materiales = null;
            
            while (rs.next()) {
                if (mantenimiento == null) {
                    mantenimiento = new ArrayList<Mantenimiento>();
                }
                Mantenimiento registro = new Mantenimiento(id, tipo, descripcion, materiales);
                id = rs.getInt("id_activo");
                registro.setId_activo(id);

                tipo = rs.getString("tipo");
                registro.setTipo(tipo);

                descripcion = rs.getString("descripcion");
                registro.setDescripcion(descripcion);

                materiales = rs.getString("materiales");
                registro.setMateriales(materiales);

                

                mantenimiento.add(registro);

            }
            if (mantenimiento != null) {
                for (int i = 0; i < mantenimiento.size(); i++) {
                    System.out.println(mantenimiento.get(i).getId_activo() + " " + mantenimiento.get(i).getTipo() + " " + mantenimiento.get(i).getDescripcion()+ " " + mantenimiento.get(i).getMateriales());
                }
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Mantenimientos");
            e.printStackTrace();
        }

        return mantenimiento;

    }

    public ArrayList<Mantenimiento> getMantenimientoID(int a) throws SQLException, URISyntaxException {
        ArrayList<Mantenimiento> mantenimiento = null;
        boolean result = false;
        String query = "SELECT * FROM mantenimiento where id_activo = " + a;
        Connection connection = DbUtil.getConnection();
        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            int id = 0;
            String tipo = null;
            String descripcion = null;
            String materiales = null;
            
            while (rs.next()) {
                if (mantenimiento == null) {
                    mantenimiento = new ArrayList<Mantenimiento>();
                }
                Mantenimiento registro = new Mantenimiento(id, tipo, descripcion, materiales);
                id = rs.getInt("id_activo");
                registro.setId_activo(id);

                tipo = rs.getString("tipo");
                registro.setTipo(tipo);

                descripcion = rs.getString("descripcion");
                registro.setDescripcion(descripcion);

                materiales = rs.getString("materiales");
                registro.setMateriales(materiales);

                

                mantenimiento.add(registro);

            }
            if (mantenimiento != null) {
                for (int i = 0; i < mantenimiento.size(); i++) {
                    System.out.println(mantenimiento.get(i).getId_activo() + " " + mantenimiento.get(i).getTipo() + " " + mantenimiento.get(i).getDescripcion()+ " " + mantenimiento.get(i).getMateriales());
                }
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Mantenimientos");
            e.printStackTrace();
        }

        return mantenimiento;

    }

    public boolean updateMantenimiento(int a, String tipo, String descripcion, String materiales) throws SQLException, URISyntaxException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "update activo set descripcion = ?, materiales = ? where id_activo = " + a;
        PreparedStatement preparedStmt = null;

        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, descripcion);
            preparedStmt.setString(2, materiales);
           

            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

}
