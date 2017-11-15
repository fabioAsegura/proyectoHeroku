package Util;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

//    private static Connection connection = null;
//
//    public static Connection getConnection() throws URISyntaxException {
//        if (connection != null) {
//            return connection;
//        } else {
//            URI dbUri = new URI(System.getenv("DATABASE_URL"));
//            String username = dbUri.getUserInfo().split(":")[0];
//            String password = dbUri.getUserInfo().split(":")[1];
//            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
//
//            if (connection == null) {
//                try {
//                    connection = DriverManager.getConnection(dbUrl, username, password);
//                } catch (SQLException e) {
//                    System.out.println("Connection Failed! Check output console");
//                    e.printStackTrace();
//                }
//
//            }
//            return connection;
//
//        }
//
//    }
    private static Connection CONEXION = null;

    public static Connection getConnection() throws SQLException {
        if (CONEXION == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                //Integracion Log4J
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            } catch (InstantiationException e) {
                //Integracion Log4J
                throw new SQLException(e);
            } catch (IllegalAccessException e) {
                //Integracion Log4J
                throw new SQLException(e);
            }

            try {
                CONEXION = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestorDB", "root", "");
            } catch (SQLException e) {
                throw new SQLException(e);
            }

        }
        return CONEXION;
    }

}
