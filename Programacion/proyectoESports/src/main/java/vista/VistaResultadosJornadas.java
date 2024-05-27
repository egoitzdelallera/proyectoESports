package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


/**
 * Vista para mostrar los resultados de todas las jornadas.
 */
public class VistaResultadosJornadas extends JFrame {
    private JPanel panelPrincipal;
    private JTextArea taConsulta;
    private JButton bSalir;
    private JScrollPane scrollPane;

    /**
     * Constructor de la clase VistaResultadosJornadas.
     * Inicializa la vista de resultados de todas las jornadas.
     */
    public VistaResultadosJornadas() {
        super("Resultados de todas las jornadas");
        setContentPane(panelPrincipal);
        setSize(600,600);
        setLocationRelativeTo(null);
        taConsulta.setEnabled(false);

        taConsulta.setDisabledTextColor(Color.black);

        panelPrincipal.setBackground(Color.black);
        taConsulta.setDisabledTextColor(Color.black);
        taConsulta.setSelectedTextColor(Color.black);
        taConsulta.setSelectionColor(Color.white);
        taConsulta.setForeground(Color.black);
        bSalir.setForeground(Color.white);
        bSalir.setBackground(Color.black);
        scrollPane.setOpaque(false);
        panelBoton.setOpaque(false);


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
     * Obtiene el JTextArea para la consulta de resultados.
     *
     * @return JTextArea para la consulta de resultados.
     */
    public JTextArea getTaConsulta() {
        return taConsulta;
    }
}
