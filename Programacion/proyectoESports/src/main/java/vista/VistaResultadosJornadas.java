package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VistaResultadosJornadas extends JFrame {
    private JPanel panelPrincipal;
    private JTextArea taConsulta;
    private JButton bSalir;
    private JScrollPane scrollPane;

    public VistaResultadosJornadas() {
        super("Resultados de todas las jornadas");
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
