package vista;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Clase que representa la vista del calendario.
 */
public class VistaCalendario extends JFrame{
    private JPanel panelPrincipal;
    private JComboBox cbCompeticion;
    private JTextArea taJornadas;
    private JTextArea taEnfrentamientos;
    private JPanel panelCombo;
    private JPanel panelCalendario;

    /**
     * Constructor de la clase VistaCalendario.
     * Crea una nueva instancia de la ventana del calendario.
     */
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

    /**
     * Agrega un ActionListener al JComboBox de competiciones.
     *
     * @param al ActionListener a agregar.
     */
    public void addCbCompeticion(ActionListener al){
        cbCompeticion.addActionListener(al);
    }

    /**
     * Obtiene el JComboBox de competiciones.
     *
     * @return JComboBox de competiciones.
     */
    public JComboBox getCbCompeticion() {
        return cbCompeticion;
    }

    /**
     * Establece el JComboBox de competiciones.
     *
     * @param cbCompeticion JComboBox de competiciones a establecer.
     */
    public void setCbCompeticion(JComboBox cbCompeticion) {
        this.cbCompeticion = cbCompeticion;
    }

    /**
     * Obtiene el JTextArea de las jornadas.
     *
     * @return JTextArea de las jornadas.
     */
    public JTextArea getTaJornadas() {
        return taJornadas;
    }

    /**
     * Establece el JTextArea de las jornadas.
     *
     * @param taJornadas JTextArea de las jornadas a establecer.
     */
    public void setTaJornadas(JTextArea taJornadas) {
        this.taJornadas = taJornadas;
    }

    /**
     * Obtiene el JTextArea de los enfrentamientos.
     *
     * @return JTextArea de los enfrentamientos.
     */
    public JTextArea getTaEnfrentamientos() {
        return taEnfrentamientos;
    }

    /**
     * Establece el JTextArea de los enfrentamientos.
     *
     * @param taEnfrentamientos JTextArea de los enfrentamientos a establecer.
     */
    public void setTaEnfrentamientos(JTextArea taEnfrentamientos) {
        this.taEnfrentamientos = taEnfrentamientos;
    }

    /**
     * Obtiene el JPanel del combo.
     *
     * @return JPanel del combo.
     */
    public JPanel getPanelCombo() {
        return panelCombo;
    }

    /**
     * Establece el JPanel del combo.
     *
     * @param panelCombo JPanel del combo a establecer.
     */
    public void setPanelCombo(JPanel panelCombo) {
        this.panelCombo = panelCombo;
    }

    /**
     * Obtiene el JPanel del calendario.
     *
     * @return JPanel del calendario.
     */
    public JPanel getPanelCalendario() {
        return panelCalendario;
    }

    /**
     * Establece el JPanel del calendario.
     *
     * @param panelCalendario JPanel del calendario a establecer.
     */
    public void setPanelCalendario(JPanel panelCalendario) {
        this.panelCalendario = panelCalendario;
    }
}
