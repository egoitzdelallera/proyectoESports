package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VistaClasificacion extends JFrame{
    private JPanel panelPrincipal;
    private JTextArea taConsulta;
    private JButton bSalir;
    private JScrollPane scrollPane;

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

    public void addBSalirAl(ActionListener al) {
        bSalir.addActionListener(al);
    }

    public JTextArea getTaConsulta() {
        return taConsulta;
    }
}

