package controlador.controladorV;

import vista.VistaClasificacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controlador para la vista de clasificaciones.
 */
public class ControladorVClasificaciones {

    private VistaClasificacion vc;
    private ControladorV cv;


    /**
     * Constructor del controlador de clasificaciones.
     *
     * @param cv El controlador principal de la vista.
     */
    public ControladorVClasificaciones(ControladorV cv) {
        this.cv = cv;
    }

    /**
     * Muestra la interfaz de usuario para administrar clasificaciones.
     *
     * @throws Exception Si ocurre un error al mostrar las clasificaciones.
     */
    public void mostrarClasificaciones() throws Exception {

        // Se inicializa la vista y se configura
        vc = new VistaClasificacion();
        vc.setVisible(true);
        // Se trunca la tabla de clasificaciones y se llama al procedimiento para generar el XML
        cv.truncarTabla("TRUNCATE TABLE clasificacion");
        cv.llamarProcedimiento("BEGIN paquete_xml.generar_xml_clasificaciones; END;");
        // Se obtiene el XML de la tabla de clasificaciones y se muestra en el área de texto
        vc.getTaConsulta().setText(cv.obtenerXml("SELECT * FROM clasificacion"));
        // Se agrega el listener para el botón de salir
        vc.addBSalirAl(new BSalirAl());
    }

    /**
     * ActionListener para el botón de salir.
     */
    public class BSalirAl implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vc.dispose();
        }
    }
}
