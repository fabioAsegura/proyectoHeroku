/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Supervisor;
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
public class SupervisorDAO {

    private Connection connection;

    public SupervisorDAO() throws SQLException, URISyntaxException {
        connection = DbUtil.getConnection();
    }

    public boolean addSupervisor(Supervisor supervisor) throws SQLException, URISyntaxException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "insert into supervisor (id_supervisor,nombre_supervisor,apellido_supervisor,fecha_entrada) values (?, ?, ?, ? );";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, supervisor.getId());
            preparedStmt.setString(2, supervisor.getNombre());
            preparedStmt.setString(3, supervisor.getApellido());
            preparedStmt.setString(4, supervisor.getFechaEntrada());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean deleteSupervidor(int a) throws SQLException, URISyntaxException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "delete from supervisor where id_supervisor = ?";
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

    public ArrayList<Supervisor> getAllSupervisor() throws SQLException, URISyntaxException {
        ArrayList<Supervisor> supervisor = null;
        boolean result = false;
        String query = "SELECT * FROM supervisor";
        Connection connection = DbUtil.getConnection();
        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            int id = 0;
            String nombre = null;
            String apellido = null;
            String fecha_Entrada = null;

            while (rs.next()) {
                if (supervisor == null) {
                    supervisor = new ArrayList<Supervisor>();
                }
                Supervisor registro = new Supervisor(id, nombre, apellido, fecha_Entrada);
                id = rs.getInt("id_supervisor");
                registro.setId(id);

                nombre = rs.getString("nombre_supervisor");
                registro.setNombre(nombre);

                apellido = rs.getString("apellido_supervisor");
                registro.setApellido(apellido);

                fecha_Entrada = rs.getString("fecha_entrada");
                registro.setFechaEntrada(fecha_Entrada);

                supervisor.add(registro);

            }
            if (supervisor != null) {
                for (int i = 0; i < supervisor.size(); i++) {
                    System.out.println(supervisor.get(i).getId() + " " + supervisor.get(i).getNombre() + " " + supervisor.get(i).getApellido() + " " + supervisor.get(i).getFechaEntrada());
                }
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Supervisores");
            e.printStackTrace();
        }

        return supervisor;

    }

    public ArrayList<Supervisor> getSupervisorID(int a) throws SQLException, URISyntaxException {
        ArrayList<Supervisor> supervisor = null;
        boolean result = false;
        String query = "SELECT * FROM supervisor where id_supervisor = " + a;
        Connection connection = DbUtil.getConnection();
        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            int id = 0;
            String nombre = null;
            String apellido = null;
            String fecha_Entrada = null;

            while (rs.next()) {
                if (supervisor == null) {
                    supervisor = new ArrayList<Supervisor>();
                }
                Supervisor registro = new Supervisor(id, nombre, apellido, fecha_Entrada);
                id = rs.getInt("id_supervisor");
                registro.setId(id);

                nombre = rs.getString("nombre_supervisor");
                registro.setNombre(nombre);

                apellido = rs.getString("apellido_supervisor");
                registro.setApellido(apellido);

                fecha_Entrada = rs.getString("fecha_entrada");
                registro.setFechaEntrada(fecha_Entrada);

                supervisor.add(registro);

            }
            if (supervisor != null) {
                for (int i = 0; i < supervisor.size(); i++) {
                    System.out.println(supervisor.get(i).getId() + " " + supervisor.get(i).getNombre() + " " + supervisor.get(i).getApellido() + " " + supervisor.get(i).getFechaEntrada());
                }
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Supervisores");
            e.printStackTrace();
        }

        return supervisor;

    }

    public boolean updateSupervisor(int a, String nombre, String apellido, String fechaEntrada) throws SQLException, URISyntaxException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "update supervisor set nombre_supervisor = ?, apellido_supervisor = ?, fecha_entrada = ? where id_supervisor = " + a;
        PreparedStatement preparedStmt = null;

        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, nombre);
            preparedStmt.setString(2, apellido);
            preparedStmt.setString(3, fechaEntrada);

            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

}
