package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;

public class SQLCliente extends Conexion {

    Cliente c;
    PreparedStatement ps;
    ResultSet rs;
    Connection con = getConexion();
    public ArrayList<Cliente> clientes;

    public boolean insertar(Cliente c) {
        try {
            String sql = "INSERT INTO Cliente VALUES (?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getIdCliente());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getDireccion());
            ps.setString(4, c.getTelefono());
            ps.setString(5, c.getDni());
            ps.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean consultar(Cliente c, String Dni) {
        clientes = new ArrayList<Cliente>();
        try {
            String sql = "SELECT * FROM Cliente WHERE Dni like ? ";
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + Dni + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setIdCliente(rs.getInt("idCliente"));
                c.setNombre(rs.getString("Nombre"));
                c.setDireccion(rs.getString("Direccion"));
                c.setTelefono(rs.getString("Telefono"));
                c.setDni(rs.getString("Dni"));
                clientes.add(c);
            }
            c.setArregloClientes(clientes);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminar(Cliente c) {
        try {
            String sql = "DELETE FROM Cliente WHERE idCliente = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getIdCliente());
            ps.execute();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
