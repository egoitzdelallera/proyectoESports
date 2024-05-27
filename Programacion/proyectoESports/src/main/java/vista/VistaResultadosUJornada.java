package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Vista para mostrar los resultados de la última jornada.
 */
public class VistaResultadosUJornada extends JFrame {
    private JPanel panelPrincipal;
    private JScrollPane scrollPane;
    private JTextArea taConsulta;
    private JButton bSalir;

    /**
     * Constructor de la clase VistaResultadosUJornada.
     * Inicializa la vista de resultados de la última jornada.
     */
    public VistaResultadosUJornada() {
        super("Resultados de la última jornada");
        setContentPane(panelPrincipal);
        setSize(600,600);
        setLocationRelativeTo(null);
        taConsulta.setEnabled(false);
        taConsulta.setDisabledTextColor(Color.black);

    }

    /**
     * Agrega un ActionListener al botón de salir.
     *
     * @param al ActionListener a ser agregado.
     */
    public void addBSalirAl(ActionListener al) {
        bSalir.addActionListener(al);
    }


    /**
     * Obtiene el JTextArea para la consulta de resultados de la ultima jornada.
     *
     * @return JTextArea para la consulta de resultados de la utlima jornada.
     */
    public JTextArea getTaConsulta() {
        return taConsulta;
    }
}
