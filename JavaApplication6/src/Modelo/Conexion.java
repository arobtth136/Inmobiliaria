package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private final String base = "Inmobilaria";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/" + base + "?";


    public static java.sql.Connection getConexion(String user, String password) {
        Connection conexion = null;
        try {
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Inmobilaria?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexion;
    }

//  public com.mysql.jdbc.Connection getConexion() {
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            con = (com.mysql.jdbc.Connection) DriverManager.getConnection(this.url, this.user, this.password);
//
//        } catch (SQLException e) {
//            System.err.println(e);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return con;
//    }
}
