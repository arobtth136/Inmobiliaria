package Main;

import Controlador.ControladorVistaPrincipal;
import Vista.pnlAltaCliente;
import Vista.vistaPrincipal;

public class Main {
    public static void main(String[] args) {
        ControladorVistaPrincipal c = new ControladorVistaPrincipal(new vistaPrincipal(), new pnlAltaCliente());
    }
}
