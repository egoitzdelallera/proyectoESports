package controlador.controladorV;

import vista.PaginaPrincipal;
import vista.VistaEquipos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVEquipos {

    private VistaEquipos ve;
    private ControladorV cv;
    public ControladorVEquipos(ControladorV cv) {
        this.cv = cv;
    }
    public void mostrarEquipos() {
        ve = new VistaEquipos();

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
