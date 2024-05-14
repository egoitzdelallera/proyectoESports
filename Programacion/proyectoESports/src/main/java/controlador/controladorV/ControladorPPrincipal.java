package controlador.controladorV;

import vista.PaginaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPPrincipal {

    private PaginaPrincipal pp;
    private ControladorV cv;
    public ControladorPPrincipal(ControladorV cv) {
        this.cv = cv;
    }
    public void mostrarPrincipal() {
        // Crea, muestra y pone a escuchar la ventana principal.
        pp = new PaginaPrincipal();

        pp.addBCompeticionesAl(new BCompeticionesAl());
        pp.addBEquiposAl(new BEquiposAl());
        pp.addBJuegosAl(new BJuegosAl());
        pp.addBPatrocinadoresAl(new BPatrocinadoresAl());
        pp.addBJugadoresAl(new BJugadoresAl());
        pp.addBUsuariosAl(new BUsuariosAl());
        pp.addBStaffAl(new BStaffAl());
        pp.addBClasificacionAl(new BClasificacionAl());
        pp.addBResultadosAl(new BResultadosAl());

        pp.addBSalirAl(new BSalirAl());

        pp.setVisible(true);
    }
    public class BEquiposAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            cv.mostrarEquipos();
        }
    }
    public class BCompeticionesAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            cv.mostrarCompeticiones();
        }
    }
    public class BJuegosAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            cv.mostrarJuegos();
        }
    }
    public class BJugadoresAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            cv.mostrarJugadores();
        }
    }
    public class BUsuariosAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            cv.mostrarUsuarios();
        }
    }
    public class BStaffAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            cv.mostrarStaff();
        }
    }
    public class BPatrocinadoresAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            cv.mostrarPatrocinadores();
        }
    }
    public class BSalirAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

           System.exit(0);
        }
    }
}
