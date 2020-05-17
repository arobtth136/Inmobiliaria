/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.Propiedades;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author reymi
 */
public class PropiedadesController extends Conexion {

    Connection con = getConexion();
    Statement consulta;
    ResultSet rs;
    PreparedStatement ps;
    ArrayList<Propiedades> propiedades = new ArrayList<>(); 

    public ArrayList<Propiedades> CargarPropiedades() {
        try {
            consulta = con.createStatement();
            rs = consulta.executeQuery("select * from propiedad");
            while (rs.next()) {
                Propiedades propiedad = new Propiedades(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getDouble(6), "");
                //Obtener el empleado que gestiona la propiedad
                PreparedStatement statement = con.prepareStatement("select Nombre from empleado where idEmpleado = ?");
                statement.setInt(1, rs.getInt(7));
                ResultSet rsAux = statement.executeQuery();
                rsAux.next();
                propiedad.setEmpleado(rsAux.getString(1));
                //Obtener los Dueños de la propiedad
                int IdPropietario = rs.getInt(1);
                statement = con.prepareStatement("select DniDueño from DueñosPropiedad where idPropiedad = ?");
                statement.setInt(1, IdPropietario);
                rsAux = statement.executeQuery();
                if (rsAux.next()) {
                    //Tiene dueños
                    ArrayList<Integer> propietarios = new ArrayList<>();
                    while (rsAux.next()) {
                        propietarios.add(rsAux.getInt(1));
                    }
                    propiedad.setDueños(propietarios);
                    //La propiedad tiene dueños, debemos conocer si está vendida o rentada
                    //Obtener el estado de la propiedad renta o vendida
                    statement = con.prepareStatement("select idAlquiler from alquiler where idPropiedad = ?");
                    statement.setInt(1, rs.getInt(1));
                    rsAux = statement.executeQuery();
                    if (rsAux.next()) {
                        //La casa esá en renta
                        propiedad.setEstado("En renta");
                    } else {
                        //La casa está vendida
                        propiedad.setEstado("Vendida");
                    }
                } else {
                    //La casa está disponible para la venta y omite el paso de conocer su estado
                    propiedad.setEstado("En venta");
                }
                propiedades.add(propiedad);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PropiedadesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return propiedades;
    }

    public JTable CargarTabla(JTable tabla, ArrayList<Propiedades> propiedades) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Dirección");
        modelo.addColumn("Tipo");
        modelo.addColumn("Costo de venta");
        modelo.addColumn("Costo de renta");
        modelo.addColumn("Estado");
        tabla.setModel(modelo);
        //Creamos el objeto para la tabla
        for (Propiedades propiedad : propiedades) {
            Object[] fila = new Object[5];
            fila[0] = propiedad.getDireccion();
            fila[1] = propiedad.getTipo();
            fila[2] = "$ " + propiedad.getPrecio();
            fila[3] = "$ " + propiedad.getPrecioAlquiler();
            fila[4] = propiedad.getEstado();
            modelo.addRow(fila);
        }
        return tabla;
    }

    public String GetNombreEmpleado(int ID) {
        try {
            PreparedStatement statement = con.prepareStatement("select Nombre from empleado where idEmpleado = ?");
            statement.setInt(1, ID);
            rs = statement.executeQuery();
            if (rs.next()) {
                //El empleado existe
                return rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PropiedadesController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public int GetIdEmpleado(String Nombre) {
        try {
            PreparedStatement statement = con.prepareStatement("select idEmpleado from empleado where Nombre = ?");
            statement.setString(1, Nombre);
            rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PropiedadesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public JComboBox<String> CargarCategorias(JComboBox<String> categorias) {
        try {
            consulta = con.createStatement();
            rs = consulta.executeQuery("select distinct Tipo from propiedad");
            while (rs.next()) {
                categorias.addItem(rs.getString(1));
            }
            return categorias;
        } catch (SQLException ex) {
            Logger.getLogger(PropiedadesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void GuardarCambios(JPanel image, JTextField precioVenta, JTextField precioRenta, JTextArea direccion, JComboBox categoria, JTextField tamaño, int ID, int IdPropiedad) {
        try {
            PreparedStatement statement = con.prepareStatement("update propiedad set Direccion = ?, Tipo = ?, Tamaño = ?, Precio = ?, PrecioAlquiler = ?, idEmpleado = ? where idPropiedad = ?");
            statement.setString(1, direccion.getText());
            statement.setString(2, (String) categoria.getSelectedItem());
            statement.setString(3, tamaño.getText());
            statement.setDouble(4, Double.parseDouble(precioVenta.getText()));
            statement.setDouble(5, Double.parseDouble(precioRenta.getText()));
            statement.setInt(6, ID);
            statement.setInt(7, IdPropiedad);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Propiedad Actualizada");
            
        } catch (SQLException ex) {
            Logger.getLogger(PropiedadesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void NuevaPropiedad(JPanel image, JTextField precioVenta, JTextField precioRenta, JTextArea direccion, JComboBox categoria, JTextField tamaño, int ID) {
        try {
            PreparedStatement statement = con.prepareStatement("insert into propiedad(Direccion, Tipo, Tamaño, Precio, PrecioAlquiler, idEmpleado) values(?,?,?,?,?,?)");
            statement.setString(1, direccion.getText());
            statement.setString(2, (String) categoria.getSelectedItem());
            statement.setString(3, tamaño.getText());
            statement.setDouble(4, Double.parseDouble(precioVenta.getText()));
            statement.setDouble(5, Double.parseDouble(precioRenta.getText()));
            statement.setInt(6, ID);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Propiedad registrada");
        } catch (SQLException ex) {
            Logger.getLogger(PropiedadesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
