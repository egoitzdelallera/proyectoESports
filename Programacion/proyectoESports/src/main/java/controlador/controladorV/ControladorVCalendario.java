package controlador.controladorV;

import modelo.Competicion;
import modelo.Enfrentamiento;
import modelo.Jornada;
import vista.VistaCalendario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControladorVCalendario {

    private ControladorV cv;
    private VistaCalendario vcal;
    private List<Competicion> listaCompe;
    private int combo = 0;
    private Competicion comp;
    private Jornada jor;
    private Enfrentamiento enf;

    public ControladorVCalendario(ControladorV cv)
    {
        this.cv = cv;
    }

    public void mostrarCalendario(){
        vcal = new VistaCalendario();

        vcal.addCbCompeticion(new BVisualizarJornadaYEnfrentamientosAl());

        vcal.getPanelCombo().setVisible(true);
        vcal.getPanelCalendario().setVisible(false);

        vcal.setVisible(true);

        listaCompe = cv.listaCompeticionesCerradas();
        listaCompe.forEach(o->vcal.getCbCompeticion().addItem(o.getNombre()));
    }

    public class BVisualizarJornadaYEnfrentamientosAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            combo = vcal.getCbCompeticion().getSelectedIndex();
            vcal.getPanelCalendario().setVisible(true);
            try {
                comp = cv.buscarCompeticion(vcal.getCbCompeticion().getItemAt(combo).toString());
                if (comp != null) {
                    // Obtener las jornadas
                    List<Jornada> jornadas = cv.listaJornadas(comp);

                    // Mostrar las jornadas en el JTextArea taJornadas

                    vcal.getTaJornadas().setText("");
                    for (Jornada jornada : jornadas) {
                        vcal.getTaJornadas().append(jornada.toString() + "\n"); // Ajusta según el método toString() de Jornada
                    }

                    // Obtener y mostrar los enfrentamientos de la primera jornada
                    if (!jornadas.isEmpty()) {
                        Jornada primeraJornada = jornadas.get(0);
                        List<Enfrentamiento> enfrentamientos = cv.listaEnfrentamientos();

                        // Mostrar los enfrentamientos en el JTextArea taEnfrentamientos

                        vcal.getTaEnfrentamientos().setText("");
                        for (Enfrentamiento enfrentamiento : enfrentamientos) {
                            vcal.getTaEnfrentamientos().append(enfrentamiento.toString() + "\n"); // Ajusta según el método toString() de Enfrentamiento
                        }
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                // Puedes agregar un mensaje de error a la interfaz de usuario aquí si es necesario
            }
        }
    }
}
