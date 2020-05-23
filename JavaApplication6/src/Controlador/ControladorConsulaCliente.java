package Controlador;


import Modelo.Cliente;
import Modelo.SQLCliente;
import Vista.pnlConsultaCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorConsulaCliente implements ActionListener {
    
    SQLCliente s;
    pnlConsultaCliente pc;
    Cliente c;

    public ControladorConsulaCliente() {
    }

    public ControladorConsulaCliente(SQLCliente s, pnlConsultaCliente pc, Cliente c) {
        this.s = s;
        this.pc = pc;
        this.c = c;
    }
    
    public void inicializarVista(){
        pc.btnBuscar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pc.btnBuscar) {
            System.out.println("HOLA");
            if (s.consultar(c, pc.tfDNI.getText())) {
                pc.modeloTabla.addRow(c.getArregloClietes().toArray());
                pc.tblClientes.repaint();
                for (int i = 0; i < c.getArregloClietes().size(); i++) {
                    System.out.println(c.getArregloClietes().get(i));
                }
            }
        }
    }
}


