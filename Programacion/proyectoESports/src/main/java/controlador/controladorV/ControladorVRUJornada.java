package controlador.controladorV;

import vista.VistaResultadosUJornada;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controlador para la vista de los resultados de la última jornada.
 */
public class ControladorVRUJornada {
    private ControladorV cv;
    private VistaResultadosUJornada vruj;

    /**
     * Constructor del controlador de resultados de la última jornada.
     *
     * @param cv El controlador principal de la vista.
     */
    public ControladorVRUJornada(ControladorV cv) {
        this.cv = cv;
    }

    /**
     * Muestra la vista de resultados de la última jornada.
     *
     * @throws Exception Si ocurre un error durante la ejecución del procedimiento o la consulta.
     */
    public void mostrarRUJornada() throws Exception {
        vruj = new VistaResultadosUJornada();
        vruj.setVisible(true);
        cv.truncarTabla("TRUNCATE TABLE ultima_jornada");
        cv.llamarProcedimiento("BEGIN paquete_xml.generar_ultima_jornada_xml; END;");
        vruj.getTaConsulta().setText(cv.obtenerXml("SELECT * FROM ultima_jornada"));

        vruj.addBSalirAl(new BSalirAl());
    }

    /**
     * ActionListener para el botón de salir.
     */
    public class BSalirAl implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vruj.dispose();
        }
    }
}
