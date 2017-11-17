/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Categoria;
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
 * @author LabingXEON
 */
public class CategoriaDAO {
    
        private Connection connection;

    public CategoriaDAO() throws SQLException, URISyntaxException {
        connection = DbUtil.getConnection();
    }
    
      public boolean addCategoria(Categoria categoria) throws SQLException, URISyntaxException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "insert into categoria (id_categoria,nombre,ubicacion) values (?,?,?);";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, categoria.getId());
            preparedStmt.setString(2, categoria.getNombre());
            preparedStmt.setString(3, categoria.getUbicacion());
       
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
          
                   
                              
        }
        return result;
    }
      
       public boolean deleteCategoria(int a) throws SQLException, URISyntaxException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "delete from categoria  where id_categoria= ?";
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
      
      public ArrayList<Categoria> getAllCategoria() throws SQLException, URISyntaxException {
        ArrayList<Categoria> categorias = null;
        boolean result = false;
        String query = "SELECT * FROM categoria";
        Connection connection = DbUtil.getConnection();
        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            int id_categoria = 0;
            String nombre = null;
            String ubicacion = null;
         
            while (rs.next()) {
                if (categorias == null) {
                    categorias = new ArrayList<Categoria>();
                }
                Categoria registro = new Categoria(id_categoria,nombre,ubicacion);
                id_categoria = rs.getInt("id_categoria");
                registro.setId(id_categoria);

                nombre = rs.getString("nombre");
                registro.setNombre(nombre);

                ubicacion = rs.getString("ubicacion");
                registro.setUbicacion(ubicacion);

               


                categorias.add(registro);

            }
            if (categorias != null) {
                for (int i = 0; i < categorias.size(); i++) {
                    System.out.println(categorias.get(i).getId() + " " + categorias.get(i).getNombre() + " " + categorias.get(i).getUbicacion());
                }
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Categorias");
            e.printStackTrace();
        }

        return categorias;

    }

    
}
