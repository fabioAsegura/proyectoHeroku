package Util;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbUtil {

    private static Connection connection = null;

    public static Connection getConnection() throws URISyntaxException {
        if (connection != null) {
            return connection;
        } else {
            URI dbUri;
            try {
                dbUri = new URI(System.getenv("DATABASE_URL"));
            } catch (Exception ex) {
                dbUri = null;
            }

            if (dbUri != null) {
                String username = dbUri.getUserInfo().split(":")[0];
                String password = dbUri.getUserInfo().split(":")[1];
                String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

                if (connection == null) {
                    try {
                        connection = DriverManager.getConnection(dbUrl, username, password);
                    } catch (SQLException e) {
                        System.out.println("Connection Failed! Check output console");
                        e.printStackTrace();
                    }

                }
                return connection;
            } else {
                // Especial para 
                try {
                    Class.forName("org.postgresql.Driver");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
                }

                String host = "ec2-174-129-195-73.compute-1.amazonaws.com";
                String database = "d2f64c43htkv9g";
                String user = "celhzzoxhbohzg";
                String password = "5a10474b8ed9c05a2ab9d09e7101cecb9c8bf083fcfbe3dae2deff96c80564b4";
                String port = "5432";

                String dbUrl = "jdbc:postgresql://" + host + ':' + port + "/" + database + "?user=" + user + "&password=" + password + "&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";

                if (connection == null) {
                    try {
                        connection = DriverManager.getConnection(dbUrl);
                    } catch (SQLException e) {
                        System.out.println("Connection Failed! Check output console");
                    }

                }
                return connection;
            }

        }

    }
//    private static Connection CONEXION = null;
//
//    public static Connection getConnection() throws SQLException {
//        if (CONEXION == null) {
//            try {
//                Class.forName("com.mysql.jdbc.Driver").newInstance();
//                //Integracion Log4J
//            } catch (ClassNotFoundException e) {
//                throw new SQLException(e);
//            } catch (InstantiationException e) {
//                //Integracion Log4J
//                throw new SQLException(e);
//            } catch (IllegalAccessException e) {
//                //Integracion Log4J
//                throw new SQLException(e);
//            }
//
//            try {
//                CONEXION = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestorDB", "root", "");
//            } catch (SQLException e) {
//                throw new SQLException(e);
//            }
//
//        }
//        return CONEXION;
//    }

}
