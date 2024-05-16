package controlador.controladorV;

import vista.VistaJuegos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVJuegos {
    private VistaJuegos vjg;
    private ControladorV cv;
    public ControladorVJuegos(ControladorV cv) {
        this.cv = cv;
    }
    public void mostrarUsuarios() {
        vjg = new VistaJuegos();

        // vjd.addBAceptarAl(new BAceptarAl());
        // vjd.addBBorrarAl(new BBorrarAl());
        // vjd.addBEditarAl(new BEditarAl());
        // vjd.addCbJugadoresAl(new CbJugadoresAl());
        // vjd.addCBEquiposAl(new CbEquiposAl());
        vjg.addBSalirAl(new BSalirAl());

        vjg.getPanelComboBox().setVisible(true);
    }

    public class BSalirAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vjg.dispose();
        }
    }
}
