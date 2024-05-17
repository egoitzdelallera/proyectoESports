package controlador.controladorV;


import modelo.Jugador;
import vista.VistaJugadores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVJugadores {
    private VistaJugadores vjd;
    private ControladorV cv;
    private Jugador jd;
    private int combo = 0;

    public ControladorVJugadores(ControladorV cv) {
        this.cv = cv;
    }

    public void mostrarJugadores() {
        vjd = new VistaJugadores();

        // vjd.addBAceptarAl(new BAceptarAl());
        // vjd.addBBorrarAl(new BBorrarAl());
        // vjd.addBEditarAl(new BEditarAl());
        vjd.addCbJugadoresAl(new CbJugadoresAl());
        //vjd.addCBEquiposAl(new CbEquiposAl());
        vjd.addBSalirAl(new BSalirAl());

        vjd.getPanelComboBox().setVisible(true);
    }

    public class CbJugadoresAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            combo = vjd.getCbEquipos().getSelectedIndex();
            if (combo == 0) {
                vjd.getPanelCrear().setVisible(true);
            } else {
                vjd.getPanelDatos().setVisible(true);

                try {
                    jd = cv.buscarJugador(vjd.getCbJugadores().getItemAt(combo).toString());
                    vjd.getTaDatos().setText(jd.getNombre() + jd.getNacionalidad() + jd.getNickname() + jd.getRol() + jd.getFechaNacimiento() + jd.getSueldo());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }
        }
    }

    public class BSalirAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vjd.dispose();
        }
    }

}