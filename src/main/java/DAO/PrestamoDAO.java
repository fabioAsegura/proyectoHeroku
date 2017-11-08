/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Prestamo;
import Util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gibran
 */
public class PrestamoDAO {

    private Connection connection;

    public PrestamoDAO() throws SQLException {
        connection = DbUtil.getConnection();
    }

    public boolean addPrestamo(Prestamo prestamo) throws SQLException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "insert into prestamo (prestamo.id_prestamo,prestamo.id_solicitante,prestamo.id_trabajador,prestamo.activo,prestamo.tipo,prestamo.fecha_entrada,prestamo.fecha_salida) values (?,?,?,?,?,?,?);";
        PreparedStatement preparedStmt = null;
        try {
            ArrayList<Integer> activos = prestamo.getActivo();
            for (int i = 0; i < activos.size(); i++) {
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setInt(1, prestamo.getId_prestamo());
                preparedStmt.setInt(2, prestamo.getId_solicitante());
                preparedStmt.setInt(3, prestamo.getId_trabajador());
                preparedStmt.setInt(4, activos.get(i)); //OJO
                preparedStmt.setString(5, prestamo.getTipo());
                preparedStmt.setString(6, prestamo.getFechaEntrada());
                preparedStmt.setString(7, prestamo.getFechaSalida());
                result = preparedStmt.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean deletePrestamo(int a) throws SQLException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "delete from prestamo  where id_prestamo= ?";
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

    public ArrayList<Prestamo> getAllPrestamo() throws SQLException {
        ArrayList<Prestamo> prestamo = null;
        boolean result = false;
        String query = "SELECT * FROM prestamo";
        Connection connection = DbUtil.getConnection();
        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            int id_prestamo = 0;
            int id_solicitante = 0;
            int id_trabajador = 0;
            ArrayList<Integer> activo = new ArrayList<Integer>();
            String tipo = null;
            String fechaEntrada = null;
            String fechaSalida = null;
            while (rs.next()) {
                if (prestamo == null) {
                    prestamo = new ArrayList<Prestamo>();
                }
                Prestamo registro = new Prestamo(id_prestamo, id_solicitante, id_trabajador, activo, tipo, fechaEntrada, fechaSalida);
                id_prestamo = rs.getInt("id_prestamo");
                registro.setId_prestamo(id_prestamo);

                id_solicitante = rs.getInt("id_solicitante");
                registro.setId_prestamo(id_solicitante);

                id_trabajador = rs.getInt("id_trabajador");
                registro.setId_prestamo(id_trabajador);

                String queryActivo = "SELECT id_activo FROM prestamo where id_prestamo = " + id_prestamo;
                ResultSet rsActivo = st.executeQuery(queryActivo);

                while (rsActivo.next()) {
                    int idActivo = rsActivo.getInt("id_activo");
                    activo.add(idActivo);
                }

                registro.setActivo(activo);

                tipo = rs.getString("tipo");
                registro.setTipo(tipo);

                fechaEntrada = rs.getString("fecha_entrada");
                registro.setFechaEntrada(fechaEntrada);

                fechaSalida = rs.getString("fecha_salida");
                registro.setFechaEntrada(fechaSalida);

                prestamo.add(registro);

            }

            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Activos");
            e.printStackTrace();
        }

        return prestamo;

    }
}
