package controlador.controladorV;

import vista.VistaResultadosUJornada;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVRUJornada {
    private ControladorV cv;
    private VistaResultadosUJornada vruj;

    public ControladorVRUJornada(ControladorV cv) {
        this.cv = cv;
    }

    public void mostrarRUJornada() throws Exception {
        vruj = new VistaResultadosUJornada();
        vruj.setVisible(true);
        cv.truncarTabla("TRUNCATE TABLE ultima_jornada");
        cv.llamarProcedimiento("BEGIN paquete_xml.generar_ultima_jornada_xml; END;");
        vruj.getTaConsulta().setText(cv.obtenerXml("SELECT * FROM ultima_jornada"));

        vruj.addBSalirAl(new BSalirAl());
    }

    public class BSalirAl implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vruj.dispose();
        }
    }
}
