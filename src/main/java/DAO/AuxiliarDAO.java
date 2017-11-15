/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Auxiliar;
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
public class AuxiliarDAO {

    private Connection connection;

    public AuxiliarDAO() throws SQLException, URISyntaxException {
        connection = DbUtil.getConnection();
    }

    public boolean addAuxiliar(Auxiliar auxiliar) throws SQLException, URISyntaxException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "insert into auxiliar (auxiliar.id_auxiliar,auxiliar.nombre_auxiliar,auxiliar.apellido_auxiliar,auxiliar.fecha_entrada,auxiliar.turno,auxiliar.id_supervisor) values (?, ?, ?, ?, ?, ?);";

        PreparedStatement preparedStmt = null;
        try {

            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, auxiliar.getId());
            preparedStmt.setString(2, auxiliar.getNombre());
            preparedStmt.setString(3, auxiliar.getApellido());
            preparedStmt.setString(4, auxiliar.getFechaEntrada());
            preparedStmt.setString(5, auxiliar.getTurno());
            preparedStmt.setInt(6, auxiliar.getId_supervisor());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean deleteAuxiliar(int a) throws SQLException, URISyntaxException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "delete from auxiliar where id_auxiliar = ?";
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

    public ArrayList<Auxiliar> getAllAuxiliar() throws SQLException, URISyntaxException {
        ArrayList<Auxiliar> auxiliar = null;
        boolean result = false;
        String query = "SELECT * FROM auxiliar";
        Connection connection = DbUtil.getConnection();
        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            int id = 0;
            String nombre = null;
            String apellido = null;
            String fechaEntrada = null;
            String turno = null;
            int id_supervisor = 0;
            while (rs.next()) {
                if (auxiliar == null) {
                    auxiliar = new ArrayList<Auxiliar>();
                }
                Auxiliar registro = new Auxiliar(id, nombre, apellido, fechaEntrada, turno, id_supervisor);
                id = rs.getInt("id_auxiliar");
                registro.setId(id);

                nombre = rs.getString("nombre_auxiliar");
                registro.setNombre(nombre);

                apellido = rs.getString("apellido_auxiliar");
                registro.setApellido(apellido);

                fechaEntrada = rs.getString("fecha_entrada");
                registro.setFechaEntrada(fechaEntrada);

                turno = rs.getString("turno");
                registro.setTurno(turno);

                id_supervisor = rs.getInt("id_supervisor");
                registro.setId_supervisor(id_supervisor);

                auxiliar.add(registro);

            }
            if (auxiliar != null) {
                for (int i = 0; i < auxiliar.size(); i++) {
                    System.out.println(auxiliar.get(i).getId() + " " + auxiliar.get(i).getNombre() + " " + auxiliar.get(i).getApellido() + " " + auxiliar.get(i).getFechaEntrada() + " " + auxiliar.get(i).getId_supervisor());
                }
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Auxiliares");
            e.printStackTrace();
        }

        return auxiliar;

    }

    public ArrayList<Auxiliar> getAuxiliarID(int a) throws SQLException, URISyntaxException {
        ArrayList<Auxiliar> auxiliar = null;
        boolean result = false;
        String query = "SELECT * FROM auxiliar where id_auxiliar = " + a;
        Connection connection = DbUtil.getConnection();
        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            int id = 0;
            String nombre = null;
            String apellido = null;
            String fechaEntrada = null;
            String turno = null;
            int id_supervisor = 0;
            while (rs.next()) {
                if (auxiliar == null) {
                    auxiliar = new ArrayList<Auxiliar>();
                }
                Auxiliar registro = new Auxiliar(id, nombre, apellido, fechaEntrada, turno, id_supervisor);
                id = rs.getInt("id_auxiliar");
                registro.setId(id);

                nombre = rs.getString("nombre_auxiliar");
                registro.setNombre(nombre);

                apellido = rs.getString("apellido_auxiliar");
                registro.setApellido(apellido);

                fechaEntrada = rs.getString("fecha_entrada");
                registro.setFechaEntrada(fechaEntrada);

                turno = rs.getString("turno");
                registro.setTurno(turno);

                id_supervisor = rs.getInt("id_supervisor");
                registro.setId_supervisor(id_supervisor);

                auxiliar.add(registro);

            }
            if (auxiliar != null) {
                for (int i = 0; i < auxiliar.size(); i++) {
                    System.out.println(auxiliar.get(i).getId() + " " + auxiliar.get(i).getNombre() + " " + auxiliar.get(i).getApellido() + " " + auxiliar.get(i).getFechaEntrada() + " " + auxiliar.get(i).getId_supervisor());
                }
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Auxiliares");
            e.printStackTrace();
        }

        return auxiliar;

    }

    public boolean updateAuxiliar(int a, String nombre, String apellido, String fechaEntrada, String turno, int id_supervisor) throws SQLException, URISyntaxException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "update auxiliar set nombre_auxiliar = ?, apellido_auxiliar = ?, fecha_entrada = ?, turno = ?, id_supervisor = ? where id_auxiliar = " + a;
        PreparedStatement preparedStmt = null;

        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, nombre);
            preparedStmt.setString(2, apellido);
            preparedStmt.setString(3, fechaEntrada);
            preparedStmt.setString(4, turno);
            preparedStmt.setInt(5, id_supervisor);

            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

}
