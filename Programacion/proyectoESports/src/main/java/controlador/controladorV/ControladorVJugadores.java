package controlador.controladorV;

import vista.VistaEquipos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVJugadores {
    private VistaEquipos ve;
    private ControladorV cv;
    public ControladorVJugadores(ControladorV cv) {
        this.cv = cv;
    }
    public void mostrarJugadores() {
        ve = new VistaJugadores();

        ve.addBAceptarAl(new BAceptarAl());
        ve.addBBorrarAl(new BBorrarAl());
        ve.addBEditarAl(new BEditarAl());
        ve.addCbEquiposAl(new CbEquiposAl());
        ve.addBSalirAl(new BSalirAl());

        ve.getPanelComboBox().setVisible(true);
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
