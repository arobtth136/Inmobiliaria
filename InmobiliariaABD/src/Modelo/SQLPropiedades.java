package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLPropiedades extends Conexion {

    Propiedades p;
    PreparedStatement ps;
    ResultSet rs;
    Connection con = getConexion();

    public boolean registrarPropiedad(Propiedades p) throws SQLException {
        this.p = p;
        String sql = "INSERT INTO Propiedad values (?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(0, p.getID());
            ps.setString(1, p.getDireccion());
            ps.setString(2, p.getTipo());
            ps.setString(3, p.getTamaño());
            ps.setDouble(4, p.getPrecio());
            ps.setDouble(5, p.getPrecioAlquiler());
            ps.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean consultar(Propiedades p) {
        this.p = p;
        String sql = "SELECT * FROM Propiedad WHERE ? = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(0, sql);
            ps.setString(1, sql);
            rs = ps.executeQuery();
            while (rs.next()) {
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean actualizar(Propiedades p){
        this.p = p;
        String sql = "UPDATE Propiedad SET";
        return true;
    }
    
    public boolean eliminarPropiedad(Propiedades p) {
        this.p = p;
        String sql = "DELETE FROM Propiedad WHERE ID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(0, p.getID());
            ps.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
