package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VistaCalendario extends JFrame{
    private JPanel panelPrincipal;
    private JComboBox cbCompeticion;
    private JTextArea taJornadas;
    private JTextArea taEnfrentamientos;
    private JPanel panelCombo;
    private JPanel panelCalendario;

    public VistaCalendario(){
        super("Calendario");
        setContentPane(panelPrincipal);
        setSize(800,600);
        setLocationRelativeTo(null);
        panelPrincipal.setBackground(Color.black);
        panelCombo.setOpaque(false);
        panelCalendario.setOpaque(false);
        cbCompeticion.setBackground(Color.black);
        cbCompeticion.setForeground(Color.white);
        taJornadas.setEnabled(false);
        taJornadas.setDisabledTextColor(Color.black);
        taJornadas.setSelectedTextColor(Color.black);
        taJornadas.setSelectionColor(Color.white);
        taEnfrentamientos.setEnabled(false);
        taEnfrentamientos.setDisabledTextColor(Color.black);
        taEnfrentamientos.setSelectedTextColor(Color.black);
        taEnfrentamientos.setSelectionColor(Color.white);
    }

    public void addCbCompeticion(ActionListener al){
        cbCompeticion.addActionListener(al);
    }

    public JComboBox getCbCompeticion() {
        return cbCompeticion;
    }

    public void setCbCompeticion(JComboBox cbCompeticion) {
        this.cbCompeticion = cbCompeticion;
    }

    public JTextArea getTaJornadas() {
        return taJornadas;
    }

    public void setTaJornadas(JTextArea taJornadas) {
        this.taJornadas = taJornadas;
    }

    public JTextArea getTaEnfrentamientos() {
        return taEnfrentamientos;
    }

    public void setTaEnfrentamientos(JTextArea taEnfrentamientos) {
        this.taEnfrentamientos = taEnfrentamientos;
    }

    public JPanel getPanelCombo() {
        return panelCombo;
    }

    public void setPanelCombo(JPanel panelCombo) {
        this.panelCombo = panelCombo;
    }

    public JPanel getPanelCalendario() {
        return panelCalendario;
    }

    public void setPanelCalendario(JPanel panelCalendario) {
        this.panelCalendario = panelCalendario;
    }
}
