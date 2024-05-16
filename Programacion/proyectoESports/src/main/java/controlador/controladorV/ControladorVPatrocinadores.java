package controlador.controladorV;

import vista.VistaPatrocinadores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVPatrocinadores {
    private VistaPatrocinadores vpt;
    private ControladorV cv;
    public ControladorVPatrocinadores(ControladorV cv) {
        this.cv = cv;
    }
    public void mostrarUsuarios() {
        vpt = new VistaPatrocinadores();

        // vjd.addBAceptarAl(new BAceptarAl());
        // vjd.addBBorrarAl(new BBorrarAl());
        // vjd.addBEditarAl(new BEditarAl());
        // vjd.addCbJugadoresAl(new CbJugadoresAl());
        // vjd.addCBEquiposAl(new CbEquiposAl());
        vpt.addBSalirAl(new BSalirAl());

        vpt.getPanelComboBox().setVisible(true);
    }

    public class BSalirAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vpt.dispose();
        }
    }
}
