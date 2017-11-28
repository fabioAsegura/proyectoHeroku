/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Model.Login;
import Util.DbUtil;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Gibran
 */
public class LoginDAO {
     private Connection connection;

    public LoginDAO() throws SQLException, URISyntaxException {
        connection = DbUtil.getConnection();
    }
    public ArrayList<Login> getLogin(String usuario, String contrasena) throws SQLException, URISyntaxException {
        ArrayList<Login> login = null;
        boolean result = false;
        String query = "SELECT * FROM login where usuario = " +usuario+ "and contrasena=" + contrasena  ;
        Connection connection = DbUtil.getConnection();
        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            Login registro = null;
            String usuario1  = null;
            String contrasena1 = null;
            
            
            while (rs.next()) {
                if (login == null) {
                    login = new ArrayList<Login>();
                }
                registro = new Login(usuario1,contrasena1);
               
                usuario1 = rs.getString("usuario");
                registro.setUsuario(usuario1);

                contrasena1 = rs.getString("contrasena");
                registro.setContrasena(contrasena1);

               

                login.add(registro);

            }
            if (login != null) {
                for (int i = 0; i < login.size(); i++) {
                    System.out.println(login.get(i).getUsuario()+ " " + login.get(i).getTipo());
                }
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener el Usuario");
            e.printStackTrace();
        }

        return login;

    }
}
