package Modelo;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private final String base = "inmobilaria";
    private final String user = "root";
    private final String password = "root1234";
    private final String url = "jdbc:mysql://localhost:3306/" + base;

    private com.mysql.jdbc.Connection con = null;

    public com.mysql.jdbc.Connection getConexion() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (com.mysql.jdbc.Connection) DriverManager.getConnection(this.url, this.user, this.password);

        } catch (SQLException e) {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
