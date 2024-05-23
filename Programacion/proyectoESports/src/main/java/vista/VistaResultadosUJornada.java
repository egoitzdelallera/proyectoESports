package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VistaResultadosUJornada extends JFrame {
    private JPanel panelPrincipal;
    private JScrollPane scrollPane;
    private JTextArea taConsulta;
    private JButton bSalir;

    public VistaResultadosUJornada() {
        super("Resultados de la última jornada");
        setContentPane(panelPrincipal);
        setSize(600,600);
        setLocationRelativeTo(null);
        taConsulta.setEnabled(false);
        taConsulta.setDisabledTextColor(Color.black);

    }

    public void addBSalirAl(ActionListener al) {
        bSalir.addActionListener(al);
    }

    public JTextArea getTaConsulta() {
        return taConsulta;
    }
}
