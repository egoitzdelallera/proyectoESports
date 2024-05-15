package controlador.controladorV;


import vista.VistaJugadores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVJugadores {
    private VistaJugadores vjd;
    private ControladorV cv;
    public ControladorVJugadores(ControladorV cv) {
        this.cv = cv;
    }
    public void mostrarJugadores() {
        vjd = new VistaJugadores();

       // vjd.addBAceptarAl(new BAceptarAl());
       // vjd.addBBorrarAl(new BBorrarAl());
       // vjd.addBEditarAl(new BEditarAl());
       // vjd.addCbJugadoresAl(new CbJugadoresAl());
       // vjd.addCBEquiposAl(new CbEquiposAl());
        vjd.addBSalirAl(new BSalirAl());

        vjd.getPanelComboBox().setVisible(true);
    }

    public class BSalirAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                cv.terminar();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
