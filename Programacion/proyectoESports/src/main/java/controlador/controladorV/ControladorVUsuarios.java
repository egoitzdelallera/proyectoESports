package controlador.controladorV;

import vista.VistaUsuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVUsuarios {
    private VistaUsuarios vu;
    private ControladorV cv;
    public ControladorVUsuarios(ControladorV cv) {
        this.cv = cv;
    }
    public void mostrarUsuarios() {
        vu = new VistaUsuarios();

        // vjd.addBAceptarAl(new BAceptarAl());
        // vjd.addBBorrarAl(new BBorrarAl());
        // vjd.addBEditarAl(new BEditarAl());
        // vjd.addCbJugadoresAl(new CbJugadoresAl());
        // vjd.addCBEquiposAl(new CbEquiposAl());
        vu.addBSalirAl(new BSalirAl());

        vu.getPanelComboBox().setVisible(true);
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
