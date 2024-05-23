package controlador.controladorV;

import vista.VistaResultadosJornadas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVRTJornadas {
    private ControladorV cv;
    private VistaResultadosJornadas vrj;
    public ControladorVRTJornadas(ControladorV cv) {
        this.cv = cv;
    }

    public void mostrarRTJornadas() throws Exception {
        vrj = new VistaResultadosJornadas();
        vrj.setVisible(true);
        cv.truncarTabla("TRUNCATE TABLE result_jornadas");
        cv.llamarProcedimiento("BEGIN paquete_xml.generar_jornadas_xml; END;");
        vrj.getTaConsulta().setText(cv.obtenerXml("SELECT * FROM result_jornadas"));

        vrj.addBSalirAl(new BSalirAl());
    }

    public class BSalirAl implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vrj.dispose();
        }
    }
}
