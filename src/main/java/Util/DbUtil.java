package Util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {

    private static Connection CONEXION = null;

    public static Connection getConnection() throws URISyntaxException {
        if (CONEXION != null) {
            return CONEXION;
        } else {
            URI dbUri = new URI(System.getenv("DATABASE_URL"));
            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

            if (CONEXION == null) {
                try {
                    CONEXION = DriverManager.getConnection(dbUrl, username, password);
                } catch (SQLException e) {
                    System.out.println("Connection Failed! Check output console");
                    e.printStackTrace();
                }

            }
            return CONEXION;

        }

    }

    public static void closeConnection() throws SQLException {
        try {
            if (CONEXION != null) {
                CONEXION.close();
                CONEXION = null;
            }

        } catch (SQLException e) {
            //Integracion Log4J
            throw new SQLException(e);
        }

    }

}
