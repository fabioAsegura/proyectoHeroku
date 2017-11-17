/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Activo;
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
public class ActivoDAO {

    private Connection connection;

    public ActivoDAO() throws SQLException, URISyntaxException {
        connection = DbUtil.getConnection();
    }

    public boolean addActivo(Activo activo) throws SQLException, URISyntaxException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "insert into activo (id_activo,tipo,fabricante,fecha_compra,ultimo_mantenimiento,estado,prestado,calificacion,categoria) values (?,?,?,?,?,?,?,?,? );";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, activo.getId_activo());
            preparedStmt.setString(2, activo.getTipo());
            preparedStmt.setString(3, activo.getFabricante());
            preparedStmt.setString(4, activo.getFecha_compra());
            preparedStmt.setString(5, activo.getUltimo_mantenimiento());
            preparedStmt.setString(6, activo.getEstado());
            preparedStmt.setString(7, activo.getPrestado());
            preparedStmt.setInt(8, activo.getCalificacion());
            preparedStmt.setString(9, activo.getCategoria());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean deleteActivo(int a) throws SQLException, URISyntaxException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "delete from activo  where id_activo= ?";
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

    public ArrayList<Activo> getAllActivo() throws SQLException, URISyntaxException {
        ArrayList<Activo> activo = null;
        boolean result = false;
        String query = "SELECT * FROM activo";
        Connection connection = DbUtil.getConnection();
        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            int id = 0;
            String tipo = null;
            String fabricante = null;
            String fecha_compra = null;
            String ultimo_mantenimiento = null;
            String estado = null;
            String prestado = null;
            int calificacion = 0;
            String categoria = null;
            while (rs.next()) {
                if (activo == null) {
                    activo = new ArrayList<Activo>();
                }
                Activo registro = new Activo(id, tipo, fabricante, fecha_compra, ultimo_mantenimiento, estado, prestado, calificacion, categoria);
                id = rs.getInt("id_activo");
                registro.setId_activo(id);

                tipo = rs.getString("tipo");
                registro.setTipo(tipo);

                fabricante = rs.getString("fabricante");
                registro.setFabricante(fabricante);

                fecha_compra = rs.getString("fecha_compra");
                registro.setFecha_compra(fecha_compra);

                ultimo_mantenimiento = rs.getString("ultimo_mantenimiento");
                registro.setUltimo_mantenimiento(ultimo_mantenimiento);

                estado = rs.getString("estado");
                registro.setEstado(estado);

                prestado = rs.getString("prestado");
                registro.setPrestado(prestado);
                
                categoria = rs.getString("categoria");
                registro.setCategoria(categoria);
                
                calificacion = rs.getInt("calificacion");
                registro.setCalificacion(calificacion);

                activo.add(registro);

            }
            if (activo != null) {
                for (int i = 0; i < activo.size(); i++) {
                    System.out.println(activo.get(i).getId_activo() + " " + activo.get(i).getTipo() + " " + activo.get(i).getFabricante() + " " + activo.get(i).getFecha_compra() + " " + activo.get(i).getUltimo_mantenimiento() + " " + activo.get(i).getPrestado() + " " + activo.get(i).getCalificacion());
                }
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Activos");
            e.printStackTrace();
        }

        return activo;

    }

    public ArrayList<Activo> getActivoID(int a) throws SQLException, URISyntaxException {
        ArrayList<Activo> activo = null;
        boolean result = false;
        String query = "SELECT * FROM activo where id_activo = " + a;
        Connection connection = DbUtil.getConnection();
        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            int id = 0;
            String tipo = null;
            String fabricante = null;
            String fecha_compra = null;
            String ultimo_mantenimiento = null;
            String estado = null;
            String prestado = null;
            int calificacion = 0;
            String categoria = null;
            while (rs.next()) {
                if (activo == null) {
                    activo = new ArrayList<Activo>();
                }
                Activo registro = new Activo(id, tipo, fabricante, fecha_compra, ultimo_mantenimiento, estado, prestado, calificacion, categoria);
                id = rs.getInt("id_activo");
                registro.setId_activo(id);

                tipo = rs.getString("tipo");
                registro.setTipo(tipo);

                fabricante = rs.getString("fabricante");
                registro.setFabricante(fabricante);

                fecha_compra = rs.getString("fecha_compra");
                registro.setFecha_compra(fecha_compra);

                ultimo_mantenimiento = rs.getString("ultimo_mantenimiento");
                registro.setUltimo_mantenimiento(ultimo_mantenimiento);

                estado = rs.getString("estado");
                registro.setEstado(estado);

                prestado = rs.getString("prestado");
                registro.setPrestado(prestado);

                calificacion = rs.getInt("calificacion");
                registro.setCalificacion(calificacion);

                categoria = rs.getString("categoria");
                registro.setCategoria(categoria);

                activo.add(registro);

            }
            if (activo != null) {
                for (int i = 0; i < activo.size(); i++) {
                    System.out.println(activo.get(i).getId_activo() + " " + activo.get(i).getTipo() + " " + activo.get(i).getFabricante() + " " + activo.get(i).getFecha_compra() + " " + activo.get(i).getUltimo_mantenimiento() + " " + activo.get(i).getPrestado() + " " + activo.get(i).getCalificacion());
                }
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Activos");
            e.printStackTrace();
        }

        return activo;

    }

    public boolean updateActivo(int a, String tipo, String fabricante, String fecha_compra, String ultimo_mantenimiento, String estado, String prestado, int calificacion, String categoria) throws SQLException, URISyntaxException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "update activo set tipo = ?, fabricante = ?, fecha_compra = ?, ultimo_mantenimiento = ?, estado = ?, prestado = ?, categoria = ?, calificacion = ? where id_activo = " + a;
        PreparedStatement preparedStmt = null;

        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, tipo);
            preparedStmt.setString(2, fabricante);
            preparedStmt.setString(3, fecha_compra);
            preparedStmt.setString(4, ultimo_mantenimiento);
            preparedStmt.setString(5, estado);
            preparedStmt.setString(6, prestado);
            preparedStmt.setString(7, categoria);
            preparedStmt.setInt(8, calificacion);

            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
     public ArrayList<Activo> getActivoNoPrestados() throws SQLException, URISyntaxException {
        ArrayList<Activo> activo = null;
        boolean result = false;
        String query = "select * from activo where prestado='False' order by categoria" ;
        
        Connection connection = DbUtil.getConnection();
        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            int id = 0;
            String tipo = null;
            String fabricante = null;
            String fecha_compra = null;
            String ultimo_mantenimiento = null;
            String estado = null;
            String prestado = null;
            int calificacion = 0;
            String categoria = null;
            while (rs.next()) {
                if (activo == null) {
                    activo = new ArrayList<Activo>();
                }
                Activo registro = new Activo(id, tipo, fabricante, fecha_compra, ultimo_mantenimiento, estado, prestado, calificacion, categoria);
                id = rs.getInt("id_activo");
                registro.setId_activo(id);

                tipo = rs.getString("tipo");
                registro.setTipo(tipo);

                fabricante = rs.getString("fabricante");
                registro.setFabricante(fabricante);

                fecha_compra = rs.getString("fecha_compra");
                registro.setFecha_compra(fecha_compra);

                ultimo_mantenimiento = rs.getString("ultimo_mantenimiento");
                registro.setUltimo_mantenimiento(ultimo_mantenimiento);

                estado = rs.getString("estado");
                registro.setEstado(estado);

                prestado = rs.getString("prestado");
                registro.setPrestado(prestado);

                calificacion = rs.getInt("calificacion");
                registro.setCalificacion(calificacion);

                categoria = rs.getString("categoria");
                registro.setCategoria(categoria);

                activo.add(registro);

            }
            if (activo != null) {
                for (int i = 0; i < activo.size(); i++) {
                    System.out.println(activo.get(i).getId_activo() + " " + activo.get(i).getTipo() + " " + activo.get(i).getFabricante() + " " + activo.get(i).getFecha_compra() + " " + activo.get(i).getUltimo_mantenimiento() + " " + activo.get(i).getPrestado() + " " + activo.get(i).getCalificacion());
                }
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Activos");
            e.printStackTrace();
        }

        return activo;

    }

}
