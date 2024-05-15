package controlador.controladorV;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVCompeticiones {
    private VistaCompeticiones vc;
    private ControladorV cv;
    public ControladorVCompeticiones(ControladorV cv) {
        this.cv = cv;
    }
    public void mostrarUsuarios() {
        vc = new VistaCompeticiones();

        // vjd.addBAceptarAl(new BAceptarAl());
        // vjd.addBBorrarAl(new BBorrarAl());
        // vjd.addBEditarAl(new BEditarAl());
        // vjd.addCbJugadoresAl(new CbJugadoresAl());
        // vjd.addCBEquiposAl(new CbEquiposAl());
        vc.addBSalirAl(new BSalirAl());

        vc.getPanelComboBox().setVisible(true);
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
