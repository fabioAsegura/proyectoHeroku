


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Prestamo;
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
 * @author Gibran
 */
public class PrestamoDAO {

    private Connection connection;

    public PrestamoDAO() throws SQLException, URISyntaxException {
        connection = DbUtil.getConnection();
    }

    public boolean addPrestamo(Prestamo prestamo) throws SQLException, URISyntaxException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "insert into prestamo (id_prestamo,fecha_entrada,fecha_salida,tipo,activo,id_solicitante,id_trabajador) values (?,?,?,?,?,?,?);";
        PreparedStatement preparedStmt = null;
        try {
       
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setInt(1, prestamo.getId_prestamo());
                preparedStmt.setString(2, prestamo.getFecha_entrada());
                preparedStmt.setString(3, prestamo.getFecha_salida());
                preparedStmt.setString(4, prestamo.getTipo());
                preparedStmt.setString(5, prestamo.getActivo());             
                preparedStmt.setInt(6, prestamo.getId_solicitante()); 
                preparedStmt.setInt(7, prestamo.getId_trabajador());
                
                result = preparedStmt.execute();
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean deletePrestamo(int a) throws SQLException, URISyntaxException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "delete from prestamo  where id_solicitante= ?";
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

    public ArrayList<Prestamo> getAllPrestamo() throws SQLException, URISyntaxException {
        ArrayList<Prestamo> prestamo = null;
        boolean result = false;
        String query = "SELECT * FROM prestamo";
        Connection connection = DbUtil.getConnection();
        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

           
            int id_prestamo=0;
            String fecha_entrada=null;
            String fecha_salida=null;
            String tipo=null;
            String activo=null;           
            int id_solicitante=0;
            int id_trabajador=0;
            
            
            while (rs.next()) {
                if (prestamo == null) {
                    prestamo = new ArrayList<Prestamo>();
                }
                Prestamo registro = new Prestamo(id_prestamo, fecha_entrada, fecha_salida, tipo, activo, id_solicitante, id_trabajador);
                id_prestamo = rs.getInt("id_solicitante");
                registro.setId_prestamo(id_prestamo);

                fecha_entrada = rs.getString("fecha_entrada");
                registro.setFecha_entrada(fecha_entrada);
                
                fecha_salida = rs.getString("fecha_salida");
                registro.setFecha_salida(fecha_salida);

                tipo = rs.getString("tipo");
                registro.setTipo(tipo);
                
                activo = rs.getString("activo");
                registro.setActivo(activo);
                             
                id_solicitante = rs.getInt("id_solicitante");
                registro.setId_solicitante(id_solicitante);
                
                id_trabajador = rs.getInt("id_trabajador");
                registro.setId_trabajador(id_trabajador);


                prestamo.add(registro);

            }

            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Activos");
            e.printStackTrace();
        }

        return prestamo;

    }
    
     public ArrayList<Prestamo> getPrestamoID(int a) throws SQLException, URISyntaxException {
        ArrayList<Prestamo> prestamo = null;
        boolean result = false;
        String query = "SELECT * FROM prestamo where id_solicitante = " + a;
        Connection connection = DbUtil.getConnection();
        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            int id_prestamo=0;
            String fecha_entrada=null;
            String fecha_salida=null;
            String tipo=null;
            String activo=null;           
            int id_solicitante=0;
            int id_trabajador=0;
            
            while (rs.next()) {
                if (prestamo == null) {
                    prestamo = new ArrayList<Prestamo>();
                }
                Prestamo registro = new Prestamo(id_prestamo, fecha_entrada, fecha_salida, tipo, activo,id_solicitante, id_trabajador);
              
                

                fecha_entrada = rs.getString("fecha_entrada");
                registro.setFecha_entrada(fecha_entrada);
                
                fecha_salida = rs.getString("fecha_salida");
                registro.setFecha_salida(fecha_salida);

                tipo = rs.getString("tipo");
                registro.setTipo(tipo);
                
                activo = rs.getString("activo");
                registro.setActivo(activo);
                            
                id_solicitante = rs.getInt("id_solicitante");
                registro.setId_solicitante(id_solicitante);
                
                id_trabajador = rs.getInt("id_trabajador");
                registro.setId_trabajador(id_trabajador);

                id_prestamo = rs.getInt("id_solicitante");
                registro.setId_prestamo(id_prestamo);

                prestamo.add(registro);

                

            }
         
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Activos");
            e.printStackTrace();
        }

        return prestamo;

    }
     
     public boolean updatePrestamo(int a ,String fecha_entrada,String fecha_salida,String tipo,String activo, int id_solicitante,  int id_trabajador) throws SQLException, URISyntaxException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "update prestamo set  fecha_entrada = ?, fecha_salida = ?, tipo = ?, activo1 = ?, activo2 = ?, activo3 = ?, activo4 = ?, activo5 = ?,id_solicitante = ?, id_trabajador = ? where id_prestamo = " + a;
        PreparedStatement preparedStmt = null;

        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, fecha_entrada);
            preparedStmt.setString(2, fecha_salida);
            preparedStmt.setString(3, tipo);
            preparedStmt.setString(4, activo);
            preparedStmt.setInt(5, id_solicitante);
            preparedStmt.setInt(6, id_trabajador);

            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}

