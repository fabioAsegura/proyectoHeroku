


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
        String query = "insert into prestamo (id_prestamo,fecha_entrada,fecha_salida,tipo,activo1,activo2,activo3,activo4,activo5,id_solicitante,id_trabajador) values (?,?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement preparedStmt = null;
        try {
       
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setInt(1, prestamo.getId_prestamo());
                preparedStmt.setString(2, prestamo.getFecha_entrada());
                preparedStmt.setString(3, prestamo.getFecha_salida());
                preparedStmt.setString(4, prestamo.getTipo());
                preparedStmt.setString(5, prestamo.getActivo1());
                preparedStmt.setString(6, prestamo.getActivo2());
                preparedStmt.setString(7, prestamo.getActivo3());
                preparedStmt.setString(8, prestamo.getActivo4());
                preparedStmt.setString(9, prestamo.getActivo5());
                preparedStmt.setInt(10, prestamo.getId_solicitante()); 
                preparedStmt.setInt(11, prestamo.getId_trabajador());
                
                result = preparedStmt.execute();
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean deletePrestamo(int a) throws SQLException, URISyntaxException {
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
            String activo1=null;
            String activo2=null;
            String activo3=null;
            String activo4=null;
            String activo5=null;
            int id_solicitante=0;
            int id_trabajador=0;
            
            
            while (rs.next()) {
                if (prestamo == null) {
                    prestamo = new ArrayList<Prestamo>();
                }
                Prestamo registro = new Prestamo(id_prestamo, fecha_entrada, fecha_salida, tipo, activo1, activo2, activo3, activo4, activo5, id_solicitante, id_trabajador);
                id_prestamo = rs.getInt("id_prestamo");
                registro.setId_prestamo(id_prestamo);

                fecha_entrada = rs.getString("fecha_entrada");
                registro.setFecha_entrada(fecha_entrada);
                
                fecha_salida = rs.getString("fecha_salida");
                registro.setFecha_salida(fecha_salida);

                tipo = rs.getString("tipo");
                registro.setTipo(tipo);
                
                activo1 = rs.getString("activo1");
                registro.setActivo1(activo1);

                activo2 = rs.getString("activo2");
                registro.setActivo2(activo2);
                
                activo3 = rs.getString("activo3");
                registro.setActivo3(activo3);
                
                activo4 = rs.getString("activo4");
                registro.setActivo4(activo4);
                
                activo5 = rs.getString("activo5");
                registro.setActivo5(activo5);
                
                id_solicitante = rs.getInt("id_solicitante");
                registro.setId_solicitante(id_prestamo);
                
                id_trabajador = rs.getInt("id_trabajador");
                registro.setId_trabajador(id_prestamo);


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

