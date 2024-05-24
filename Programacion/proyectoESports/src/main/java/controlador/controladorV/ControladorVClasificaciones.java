package controlador.controladorV;

import vista.VistaClasificacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVClasificaciones {

    private VistaClasificacion vc;
    private ControladorV cv;

    public ControladorVClasificaciones(ControladorV cv) {
        this.cv = cv;
    }

    public void mostrarClasificaciones() throws Exception {
        vc = new VistaClasificacion();
        vc.setVisible(true);
        cv.truncarTabla("TRUNCATE TABLE clasificacion");
        cv.llamarProcedimiento("BEGIN paquete_xml.generar_xml_clasificaciones; END;");
        vc.getTaConsulta().setText(cv.obtenerXml("SELECT * FROM clasificacion"));

        vc.addBSalirAl(new BSalirAl());
    }

    public class BSalirAl implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vc.dispose();
        }
    }
}
