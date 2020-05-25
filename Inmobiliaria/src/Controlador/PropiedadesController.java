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
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
                int IdPropiedad = rs.getInt(1);
                statement = con.prepareStatement("select DniDueño from DueñosPropiedad where idPropiedad = ?");
                statement.setInt(1, IdPropiedad);
                rsAux = statement.executeQuery();
                if (rsAux.next()) {
                    //Conseguir dueños de propiedad
                    propiedad = GetDueños(propiedad);
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
                    propiedad.setDueños(new ArrayList<>());
                    propiedad.setEstado("En venta");
                }
                propiedades.add(propiedad);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PropiedadesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return propiedades;
    }

    public Propiedades GetDueños(Propiedades propiedad) {
        try {
            PreparedStatement statement = con.prepareStatement("select DniDueño from DueñosPropiedad where idPropiedad = ?");
            statement.setInt(1, propiedad.getID());
            ResultSet rs = statement.executeQuery();
            ArrayList<String> propietarios = new ArrayList<>();
            while (rs.next()) {;
                propietarios.add(rs.getString(1));
            }
            propiedad.setDueños(propietarios);
        } catch (SQLException ex) {
            Logger.getLogger(PropiedadesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return propiedad;
    }

    public JTable CargarTabla(JTable tabla, ArrayList<Propiedades> propiedades) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Dirección");
        modelo.addColumn("Tipo");
        modelo.addColumn("Costo de venta");
        modelo.addColumn("Costo de renta");
        modelo.addColumn("Estado");
        tabla.setModel(modelo);
        //Creamos el objeto para la tabla
        for (Propiedades propiedad : propiedades) {
            Object[] fila = new Object[6];
            fila[0] = propiedad.getID();
            fila[1] = propiedad.getDireccion();
            fila[2] = propiedad.getTipo();
            fila[3] = "$" + NumberFormat.getInstance().format(propiedad.getPrecio());
            fila[4] = "$ " + NumberFormat.getInstance().format(propiedad.getPrecioAlquiler());
            fila[5] = propiedad.getEstado();
            modelo.addRow(fila);
        }
        return tabla;
    }

    public JTable CargarPropietarios(JTable tabla, Propiedades propiedad) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Telefono");
        tabla.setModel(modelo);
        if (!propiedad.getDueños().isEmpty()) {
            //Obtener los nombres de los dueños
            for (String Dni : propiedad.getDueños()) {
                try {
                    PreparedStatement statement;
                    statement = con.prepareStatement("select Nombre, Telefono from cliente where Dni = ?");
                    statement.setString(1, Dni);
                    ResultSet rs = statement.executeQuery();
                    Object[] fila = new Object[2];
                    while (rs.next()) {
                        fila[0] = rs.getString(1);
                        fila[1] = rs.getString(2);
                    }
                    modelo.addRow(fila);
                } catch (SQLException ex) {
                    Logger.getLogger(PropiedadesController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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

    public void GuardarCambios(JTextField precioVenta, JTextField precioRenta, JTextArea direccion, JComboBox categoria, JTextField tamaño, int ID, int IdPropiedad) {
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

    public void AgregarPropietario(JTextField Dni, Propiedades propiedad) {
        try {
            PreparedStatement statement = con.prepareStatement("insert into dueñospropiedad(idPropiedad,DniDueño) values (?, ?)");
            statement.setInt(1, propiedad.getID());
            statement.setString(2, Dni.getText());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PropiedadesController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "El DNI no existe, registrelo antes de añadirlo al contrato");
        }
    }

    public void EliminarContrato(Propiedades propiedad) {
        PreparedStatement statement;
        try {
            statement = con.prepareStatement("delete from dueñospropiedad where idPropiedad = ?");
            statement.setInt(1, propiedad.getID());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Contrato cancelado");
        } catch (SQLException ex) {
            Logger.getLogger(PropiedadesController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public TableModel TablaPropietarios(TableModel tabla, String Dni) {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Nombre");
            modelo.addColumn("Telefono");
            PreparedStatement statement;
            statement = con.prepareStatement("select Nombre, Telefono from cliente where Dni = ?");
            statement.setString(1, Dni);
            ResultSet rs = statement.executeQuery();
            Object[] fila = new Object[2];
            while (rs.next()) {
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
            }
            modelo.addRow(fila);
            return modelo;
        } catch (SQLException ex) {
            Logger.getLogger(PropiedadesController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Este Dni no existe");
        }
        return tabla;
    }
    
    public int GetIdCliente(String nombre){
        try {
            PreparedStatement statement = con.prepareStatement("select idCliente from cliente where Nombre = ?");
            statement.setString(1, nombre);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {                
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PropiedadesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public void InsertarVenta(String Cliente, Propiedades propiedad){
        try {
            PreparedStatement statement = con.prepareStatement("insert into venta(idComprador, idEmpleado, FechaVenta, idPropiedad, PrecioInicial, PrecioFinal)"
                    + "values(?,?,?,?,?,?)");
            statement.setInt(1, GetIdCliente(Cliente));
            statement.setInt(1, 0);
        } catch (SQLException ex) {
            Logger.getLogger(PropiedadesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
