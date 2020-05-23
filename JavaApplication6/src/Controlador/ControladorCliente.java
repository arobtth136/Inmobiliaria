package Controlador;

import Modelo.Cliente;
import Modelo.SQLCliente;
import Vista.pnlAltaCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorCliente implements ActionListener {
    
    private Cliente c;
    private SQLCliente s;
    private pnlAltaCliente p;
    
    public ControladorCliente() {
        
    }
    
    public ControladorCliente(Cliente c,SQLCliente s,pnlAltaCliente p) {
        this.c = c;
        this.s = s;
        this.p = p;
        iniciarVista();
    }
    
    public void iniciarVista(){
        this.p.btnAceptar.addActionListener(this);
        this.p.btnCancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == p.btnAceptar) {
            c.setIdCliente(0);
            c.setNombre(p.tfNombre.getText());
            c.setDireccion(p.tfDireccion.getText());
            c.setTelefono(p.tfTelefono.getText());
            c.setDni(p.tfDni.getText());
            if (s.insertar(c)) {
                JOptionPane.showMessageDialog(p, "Inserción exitosa");
                p.limpiar();
            }
    }
    
}
}
