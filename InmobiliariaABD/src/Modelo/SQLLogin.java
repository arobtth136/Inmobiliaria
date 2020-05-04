package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLLogin extends Conexion{
    
    Connection con = getConexion();

    public SQLLogin() {

    }
    
    public boolean ingresar(String usuario, String password){
        String sql = "SELECT * FROM ";
    }
}
