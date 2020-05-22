package Controlador;

import Modelo.Cliente;
import Modelo.SQLCliente;
import Vista.pnlAltaCliente;
import Vista.pnlNuevaPropiedad;
import Vista.vistaPrincipal;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

public class ControladorVistaPrincipal implements ActionListener {

    pnlAltaCliente p;

    CardLayout cl = new CardLayout();
    vistaPrincipal v;

    public ControladorVistaPrincipal() {
    }

    public ControladorVistaPrincipal(vistaPrincipal v, pnlAltaCliente p) {
        this.v = v;
        inicializarVista();
        v.pnlAcciones.setLayout(cl);
    }

    public void inicializarVista() {
        v.btnClientAlta.addActionListener(this);
        v.btnClientConsulta.addActionListener(this);
        v.btnPropAlta.addActionListener(this);
        v.btnPropConsulta.addActionListener(this);
        v.btnVendAlta.addActionListener(this);
        v.btnVendConsulta.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == v.btnClientAlta) {
            p = new pnlAltaCliente();
            v.pnlAcciones.add(p, "altaCliente");
            cl.show(v.pnlAcciones, "altaCliente");
            SwingUtilities.updateComponentTreeUI(v.pnlAcciones);
            v.repaint();
            ControladorCliente c = new ControladorCliente(new Cliente(), new SQLCliente(), p);
        }

        if (e.getSource() == v.btnPropAlta) {
            pnlNuevaPropiedad pnp = new pnlNuevaPropiedad();
            v.pnlAcciones.add(pnp, "altaPropiedad");
            cl.show(v.pnlAcciones, "altaPropiedad");
            SwingUtilities.updateComponentTreeUI(v.pnlAcciones);
            v.repaint();

        }

    }
}
