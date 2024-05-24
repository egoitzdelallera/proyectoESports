package controlador.controladorV;

import vista.PaginaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controlador para la vista principal.
 */
public class ControladorVPrincipal {

    private PaginaPrincipal pp;
    private ControladorV cv;

    /**
     * Constructor del controlador principal de la vista.
     *
     * @param cv El controlador principal.
     */
    public ControladorVPrincipal(ControladorV cv) {
        this.cv = cv;
    }

    /**
     * Muestra la página principal según el rol del usuario.
     *
     * @param rolusuario El rol del usuario.
     */
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
        pp.addBResultadosAl(new BRTJornadasAl());
        pp.addBResultadosUJAl(new BRUJornadaAl());
        pp.addBSalirAl(new BSalirAl());

        pp.setVisible(true);

        // Se muestran u ocultan los botones según el rol del usuario
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
                pp.getbResultados().setVisible(true);
                pp.getbResultadosUJ().setVisible(true);
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
                pp.getbResultados().setVisible(false);
                pp.getbResultadosUJ().setVisible(true);
                pp.getbSalir().setVisible(true);
                break;
            default:
                break;

        }
    }

    /**
     * ActionListener para el botón de mostrar la página de resultados de una jornada.
     */
    public class BRUJornadaAl implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                cv.mostrarRUJornada();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * ActionListener para el botón de mostrar la página de resultados de todas las jornadas.
     */
    public class BRTJornadasAl implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                cv.mostrarRTJornadas();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * ActionListener para el botón de mostrar las clasificaciones.
     */
    public class BClasificacionesAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                cv.mostrarClasificaciones();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * ActionListener para el botón de mostrar los equipos.
     */
    public class BEquiposAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            cv.mostrarEquipos();
        }
    }

    /**
     * ActionListener para el botón de mostrar las competiciones.
     */
    public class BCompeticionesAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            cv.mostrarCompeticiones();
        }
    }

    /**
     * ActionListener para el botón de mostrar los juegos.
     */
    public class BJuegosAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            cv.mostrarJuegos();
        }
    }

    /**
     * ActionListener para el botón de mostrar los jugadores.
     */
    public class BJugadoresAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            cv.mostrarJugadores();
        }
    }

    /**
     * ActionListener para el botón de mostrar los usuarios.
     */
    public class BUsuariosAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            cv.mostrarUsuarios();
        }
    }

    /**
     * ActionListener para el botón de mostrar el staff.
     */
    public class BStaffAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarStaff();
        }
    }

    /**
     * ActionListener para el botón de mostrar los patrocinadores.
     */
    public class BPatrocinadoresAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            cv.mostrarPatrocinadores();
        }
    }

    /**
     * ActionListener para el botón de mostrar el calendario.
     */
    public class BCalendarioAl implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            cv.mostrarCalendario();
        }
    }

    /**
     * ActionListener para el botón de salir.
     */
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
