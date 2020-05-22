package Controlador;

import Vista.*;

import java.awt.event.ActionEvent;

public class Controlador implements java.awt.event.ActionListener {
    
    private vistaLogin v;

    public Controlador (vistaLogin v){
        this.v = v;
    }
    
    public void inicializarEventos(){
        v.btnIngresar.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.v.btnIngresar) {
            
        }
        
    }
    
}
