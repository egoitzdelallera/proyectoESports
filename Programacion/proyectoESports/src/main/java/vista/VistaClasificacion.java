package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


/**
 * Clase que representa la vista de la clasificación.
 */
public class VistaClasificacion extends JFrame{
    private JPanel panelPrincipal;
    private JTextArea taConsulta;
    private JButton bSalir;
    private JScrollPane scrollPane;

    /**
     * Constructor de la clase VistaClasificacion.
     * Crea una nueva instancia de la ventana de clasificación.
     */
    public VistaClasificacion() {
        super("Clasificaciones");
        setContentPane(panelPrincipal);
        setSize(600,600);
        setLocationRelativeTo(null);
        taConsulta.setEnabled(false);
        taConsulta.setDisabledTextColor(Color.black);
        //scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollPane.getVerticalScrollBar().setValue(0);
    }

    /**
     * Agrega un ActionListener al botón de salir.
     *
     * @param al ActionListener a agregar.
     */
    public void addBSalirAl(ActionListener al) {
        bSalir.addActionListener(al);
    }

    /**
     * Obtiene el JTextArea de la consulta.
     *
     * @return JTextArea de la consulta.
     */
    public JTextArea getTaConsulta() {
        return taConsulta;
    }
}

