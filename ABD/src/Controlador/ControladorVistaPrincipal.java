package Controlador;

import Modelo.Cliente;
import Modelo.SQLCliente;
import Vista.pnlAltaCliente;
import Vista.vistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

public class ControladorVistaPrincipal implements ActionListener {

    vistaPrincipal v;

    public ControladorVistaPrincipal() {
    }

    public ControladorVistaPrincipal(vistaPrincipal v, pnlAltaCliente p) {
        this.v = v;
        inicializarVista();
    }

    public void inicializarVista() {
        v.btnClientAlta.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == v.btnClientAlta) {
            pnlAltaCliente p = new pnlAltaCliente();
            v.pnlAcciones.add(p,"altaCliente");
            SwingUtilities.updateComponentTreeUI(v.pnlAcciones);
            v.repaint();
            ControladorCliente c = new ControladorCliente(new Cliente(), new SQLCliente(), p);
        }
        
        if (e.getSource() == v.btnClientConsulta) {
            
        }
    }
}
