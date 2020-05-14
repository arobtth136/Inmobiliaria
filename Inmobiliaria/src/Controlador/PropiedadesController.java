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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author reymi
 */
public class PropiedadesController extends Conexion{
    
    Connection con = getConexion();
    Statement consulta;
    ResultSet rs;
    PreparedStatement ps;
    
    public void CargarPropiedades(){
        try {
            consulta = con.createStatement();
            rs = consulta.executeQuery("select * from propiedad");
            while(rs.next()){
                Propiedades propiedad = new Propiedades(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getDouble(6), "");
                //Obtener el empleado que gestiona la propiedad
                PreparedStatement statement = con.prepareStatement("select Nombre from empleado where idEmpleado = ?");
                statement.setInt(1, rs.getInt(7));
                ResultSet rsAux = statement.executeQuery();
                propiedad.setEmpleado(rsAux.getString(1));
                //Obtener los Dueños de la propiedad
                int IdPropietario = rs.getInt(1);
                statement = con.prepareStatement("select DniDueño from DueñosPropiedad where idPropiedad = ?");
                statement.setInt(1, IdPropietario);
                rsAux = statement.executeQuery();
                if(rsAux.next()){
                    //Tiene dueños
                    ArrayList<Integer> propietarios = new ArrayList<>();
                    while(rsAux.next()){
                        propietarios.add(rsAux.getInt(1));
                    }
                    propiedad.setDueños(propietarios.toArray(new Integer[0]));
                } else {
                    //La casa está disponible para la venta y omite el paso de conocer su estado
                    propiedad.setEstado("En venta");
                    return;
                }
                //Obtener el estado de la propiedad renta o vendida
                statement = con.prepareStatement("select idAlquiler from alquiler where idPropiedad = ?");
                statement.setInt(1, rs.getInt(1));
                rsAux = statement.executeQuery();
                if(rsAux.next()){
                    //La casa esá en renta
                    propiedad.setEstado("En renta");
                } else {
                    //La casa está vendida
                    propiedad.setEstado("Vendida");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PropiedadesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String GetNombreEmpleado(int ID){
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
    
    public void GuardarCambios(JPanel image, JTextField empleado, JTextField precioVenta, JTextField precioRenta, JTextArea direccion, JComboBox categoria, JTextField tamaño, int ID){
        try {
            PreparedStatement statement = con.prepareStatement("update propiedad set Direccion = ?, Tipo = ?, Tamaño = ?, Precio = ?, PrecioAlquiler = ?, idEmpleado = ?");
            statement.setString(1, direccion.getText());
            statement.setString(2, (String) categoria.getSelectedItem());
            statement.setString(3, tamaño.getText());
            statement.setDouble(4, Double.parseDouble(precioVenta.getText()));
            statement.setDouble(5, Double.parseDouble(precioRenta.getText()));
            statement.setInt(6, ID);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PropiedadesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
