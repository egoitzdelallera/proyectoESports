package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VistaResultadosJornadas extends JFrame {
    private JPanel panelPrincipal;
    private JTextArea taConsulta;
    private JButton bSalir;
    private JScrollPane scrollPane;
    private JPanel panelBoton;

    public VistaResultadosJornadas() {
        super("Resultados de todas las jornadas");
        setContentPane(panelPrincipal);
        setSize(600,600);
        setLocationRelativeTo(null);
        taConsulta.setEnabled(false);
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

    public void addBSalirAl(ActionListener al) {
        bSalir.addActionListener(al);
    }

    public JTextArea getTaConsulta() {
        return taConsulta;
    }
}
