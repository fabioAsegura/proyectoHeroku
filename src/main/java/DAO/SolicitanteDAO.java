/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Solicitante;
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
public class SolicitanteDAO {

    private Connection connection;

    public SolicitanteDAO() throws SQLException, URISyntaxException {
        connection = DbUtil.getConnection();
    }

    public boolean addSolicitante(Solicitante solicitante) throws SQLException, URISyntaxException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "insert into solicitante (solicitante.id_solicitante,solicitante.nombre_solicitante,solicitante.apellido_solicitante,solicitante.escuela,solicitante.tipo) values (?,?,?,?,?);";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, solicitante.getId());
            preparedStmt.setString(2, solicitante.getNombre());
            preparedStmt.setString(3, solicitante.getApellido());
            preparedStmt.setString(4, solicitante.getEscuela());
            preparedStmt.setString(5, solicitante.getTipo());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean deleteSolicitante(int a) throws SQLException, URISyntaxException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "delete from solicitante where id_solicitante = ?";
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

    public ArrayList<Solicitante> getAllSolicitante() throws SQLException, URISyntaxException {
        ArrayList<Solicitante> solicitante = null;
        boolean result = false;
        String query = "SELECT * FROM solicitante";
        Connection connection = DbUtil.getConnection();
        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            int id = 0;
            String nombre = null;
            String apellido = null;
            String escuela = null;
            String tipo = null;

            while (rs.next()) {
                if (solicitante == null) {
                    solicitante = new ArrayList<Solicitante>();
                }
                Solicitante registro = new Solicitante(id, nombre, apellido, escuela, tipo);
                id = rs.getInt("id_solicitante");
                registro.setId(id);

                nombre = rs.getString("nombre_solicitante");
                registro.setNombre(nombre);

                apellido = rs.getString("apellido_solicitante");
                registro.setApellido(apellido);

                escuela = rs.getString("escuela");
                registro.setEscuela(escuela);

                tipo = rs.getString("tipo");
                registro.setTipo(tipo);

                solicitante.add(registro);

            }
            if (solicitante != null) {
                for (int i = 0; i < solicitante.size(); i++) {
                    System.out.println(solicitante.get(i).getId() + " " + solicitante.get(i).getNombre() + " " + solicitante.get(i).getApellido() + " " + solicitante.get(i).getEscuela() + " " + solicitante.get(i).getTipo());
                }
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Solicitantes");
            e.printStackTrace();
        }

        return solicitante;

    }

    public ArrayList<Solicitante> getSolicitanteID(int a) throws SQLException, URISyntaxException {
        ArrayList<Solicitante> solicitante = null;
        boolean result = false;
        String query = "SELECT * FROM solicitante where id_solicitante =" + a;
        Connection connection = DbUtil.getConnection();
        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            int id = 0;
            String nombre = null;
            String apellido = null;
            String escuela = null;
            String tipo = null;

            while (rs.next()) {
                if (solicitante == null) {
                    solicitante = new ArrayList<Solicitante>();
                }
                Solicitante registro = new Solicitante(id, nombre, apellido, escuela, tipo);
                id = rs.getInt("id_solicitante");
                registro.setId(id);

                nombre = rs.getString("nombre_solicitante");
                registro.setNombre(nombre);

                apellido = rs.getString("apellido_solicitante");
                registro.setApellido(apellido);

                escuela = rs.getString("escuela");
                registro.setEscuela(escuela);

                tipo = rs.getString("tipo");
                registro.setTipo(tipo);

                solicitante.add(registro);

            }
            if (solicitante != null) {
                for (int i = 0; i < solicitante.size(); i++) {
                    System.out.println(solicitante.get(i).getId() + " " + solicitante.get(i).getNombre() + " " + solicitante.get(i).getApellido() + " " + solicitante.get(i).getEscuela() + " " + solicitante.get(i).getTipo());
                }
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Solicitantes");
            e.printStackTrace();
        }

        return solicitante;

    }

    public boolean updateSolicitante(int a, String nombre, String apellido, String escuela, String tipo) throws SQLException, URISyntaxException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "update solicitante set nombre_solicitante = ?, apellido_solicitante = ?, escuela = ?, tipo = ? where id_solicitante = " + a;
        PreparedStatement preparedStmt = null;

        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, nombre);
            preparedStmt.setString(2, apellido);
            preparedStmt.setString(3, escuela);
            preparedStmt.setString(4, tipo);

            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

}
