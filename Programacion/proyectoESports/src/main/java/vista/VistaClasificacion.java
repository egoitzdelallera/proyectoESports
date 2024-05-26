package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VistaClasificacion extends JFrame{
    private JPanel panelPrincipal;
    private JTextArea taConsulta;
    private JButton bSalir;
    private JScrollPane scrollPane;
    private JPanel panelBoton;

    public VistaClasificacion() {
        super("Clasificaciones");
        setContentPane(panelPrincipal);
        setSize(600,600);
        setLocationRelativeTo(null);
        taConsulta.setEnabled(false);
        taConsulta.setDisabledTextColor(Color.black);
        taConsulta.setEnabled(false);
        taConsulta.setDisabledTextColor(Color.black);
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

