/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Propiedades;
import Vista.ConsultaPropiedad;
import Vista.pnlNuevaPropiedad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

public class nuevaPropiedadController implements ActionListener, KeyListener {

    PropiedadesController controller;
    pnlNuevaPropiedad p;
    private int IdEmpleado = 0;

    public nuevaPropiedadController() {
    }

    public nuevaPropiedadController(PropiedadesController controller, pnlNuevaPropiedad p) {
        this.controller = controller;
        this.p = p;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource() == p.BtnGuardar) {
            // TODO add your handling code here:
            if (!"".equals(p.Empleado.getText())) {
                if (!"".equals(p.PrecioVenta.getText())) {
                    if (!"".equals(p.PrecioRenta.getText())) {
                        if (!"".equals(p.Direccion.getText())) {
                            if (!"".equals(p.Tamaño.getText())) {
                                controller.NuevaPropiedad(p.Image, p.PrecioVenta, p.PrecioRenta, p.Direccion,p. Categorias, p.Tamaño, IdEmpleado);
                                Limpiar();
                            } else {
                                JOptionPane.showMessageDialog(null, "El tamaño no debe estár vacío");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "La dirección no debe estár vacía");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El precio de renta no debe estar vacío");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El precio de venta no debe estar vacío");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe haber alguien gestionando la propiedad");
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {

    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        if (arg0.getSource() == p.Empleado) {
            if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
                if (!"".equals(this.p.Empleado.getText())) {
                    //obtenemos el nombre
                    String nombre = controller.GetNombreEmpleado(Integer.parseInt(p.Empleado.getText()));
                    if (nombre == null) {
                        JOptionPane.showMessageDialog(null, "Este ID no existe");
                    } else {
                        IdEmpleado = Integer.parseInt(p.Empleado.getText());
                        p.Empleado.setText(nombre);
                    }
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {

    }
    
        private void Limpiar(){
        this.p.PrecioVenta.setText("");
        this.p.PrecioRenta.setText("");
        this.p.Direccion.setText("");
        this.p.Tamaño.setText("");
        this.p.Empleado.setText("");
        this.IdEmpleado = 0;   
    }

}
