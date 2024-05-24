package controlador.controladorV;

import vista.VistaResultadosJornadas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controlador para la vista de resultados de jornadas.
 */
public class ControladorVRTJornadas {
    private ControladorV cv;
    private VistaResultadosJornadas vrj;

    /**
     * Constructor del controlador de resultados de jornadas.
     *
     * @param cv El controlador principal de la vista.
     */
    public ControladorVRTJornadas(ControladorV cv) {
        this.cv = cv;
    }

    /**
     * Muestra la interfaz de usuario para los resultados de las jornadas.
     *
     * @throws Exception Si ocurre un error al interactuar con la base de datos.
     */
    public void mostrarRTJornadas() throws Exception {
        vrj = new VistaResultadosJornadas();
        vrj.setVisible(true);
        cv.truncarTabla("TRUNCATE TABLE result_jornadas");
        cv.llamarProcedimiento("BEGIN paquete_xml.generar_jornadas_xml; END;");
        vrj.getTaConsulta().setText(cv.obtenerXml("SELECT * FROM result_jornadas"));

        vrj.addBSalirAl(new BSalirAl());
    }

    /**
     * ActionListener para el botón de salir.
     */
    public class BSalirAl implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vrj.dispose();
        }
    }
}
