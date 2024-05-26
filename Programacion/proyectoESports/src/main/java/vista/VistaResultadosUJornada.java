package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VistaResultadosUJornada extends JFrame {
    private JPanel panelPrincipal;
    private JScrollPane scrollPane;
    private JTextArea taConsulta;
    private JButton bSalir;
    private JPanel panelBoton;

    public VistaResultadosUJornada() {
        super("Resultados de la última jornada");
        setContentPane(panelPrincipal);
        setSize(600,600);
        setLocationRelativeTo(null);
        panelPrincipal.setBackground(Color.black);
        taConsulta.setEnabled(false);
        taConsulta.setDisabledTextColor(Color.white);
        taConsulta.setSelectedTextColor(Color.black);
        taConsulta.setSelectionColor(Color.white);
        bSalir.setForeground(Color.white);
        bSalir.setBackground(Color.black);
        scrollPane.setOpaque(false);
        panelBoton.setOpaque(false);


    }

    public void addBSalirAl(ActionListener al) {
        bSalir.addActionListener(al);
    }

    public JTextArea getTaConsulta() {
        return taConsulta;
    }
}
