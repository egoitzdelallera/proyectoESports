package controlador.controladorV;

import vista.PaginaPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVPrincipal {

    private PaginaPrincipal pp;
    private ControladorV cv;
    public ControladorVPrincipal(ControladorV cv) {
        this.cv = cv;
    }
    public void mostrarPrincipal(String rolusuario) {
        // Crea, muestra y pone a escuchar la ventana principal.
        pp = new PaginaPrincipal();

        pp.addBCompeticionesAl(new BCompeticionesAl());
        pp.addBEquiposAl(new BEquiposAl());
        pp.addBJuegosAl(new BJuegosAl());
        pp.addBPatrocinadoresAl(new BPatrocinadoresAl());
        pp.addBJugadoresAl(new BJugadoresAl());
        pp.addBUsuariosAl(new BUsuariosAl());
        pp.addBStaffAl(new BStaffAl());
        pp.addBCalendarioAl(new BCalendarioAl());
        pp.addBSalirAl(new BSalirAl());

        pp.setVisible(true);

        switch (rolusuario){
            case "ADMINISTRADOR":
                pp.getbCompeticiones().setVisible(true);
                pp.getbEquipos().setVisible(true);
                pp.getbJuegos().setVisible(true);
                pp.getbPatrocinadores().setVisible(true);
                pp.getbJugadores().setVisible(true);
                pp.getbStaff().setVisible(true);
                pp.getbUsuarios().setVisible(true);
                pp.getbCalendario().setVisible(true);
                pp.getbSalir().setVisible(true);
                break;
            case "USUARIO":
                pp.getbCompeticiones().setVisible(false);
                pp.getbEquipos().setVisible(false);
                pp.getbJuegos().setVisible(false);
                pp.getbPatrocinadores().setVisible(false);
                pp.getbJugadores().setVisible(false);
                pp.getbStaff().setVisible(false);
                pp.getbUsuarios().setVisible(false);
                pp.getbCalendario().setVisible(true);
                pp.getbSalir().setVisible(true);
                break;
            default:
                break;

        }

         
    }

    /**
     * Todos los ActionListener para los botones de la pagina principal
     * los cuales llevan a cada pagina, ya sea de Crud o de Consultas de Calendario
     */

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

    public class BCalendarioAl implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarCalendario();
        }
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
