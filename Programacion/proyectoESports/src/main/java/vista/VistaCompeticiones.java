package vista;

import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VistaCompeticiones extends JFrame {
    private JPanel panelPrincipal;
    private JPanel panelComboBox;
    private JComboBox cbCompeticiones;
    private JPanel panelDatos;
    private JTextArea taDatos;
    private JButton bEditar;
    private JButton bBorrar;
    private JPanel panelCrear;
    private JTextField tfNombre;
    private JPanel pFechaInicio;
    private JButton bAceptar;
    private JComboBox cbAnadirEquipos;
    private JButton bAnadirEquipo;
    private JComboBox cbEliminarEquipos;
    private JButton bEliminarEquipo;
    private JButton bSalir;
    private JPanel pFechaFin;
    private JCalendar cFechaInicio;
    private JCalendar cFechaFin;


    public VistaCompeticiones() {
        super("Competiciones");
        setContentPane(panelPrincipal);
        setSize(1000,500);
        setLocationRelativeTo(null);
        cFechaInicio = new JCalendar();
        cFechaFin = new JCalendar();
        pFechaInicio.add(cFechaInicio);
        pFechaFin.add(cFechaFin);
    }

    public void addBEditarAl (ActionListener al){
        bEditar.addActionListener(al);
    }
    public void addBBorrarAl (ActionListener al){
        bBorrar.addActionListener(al);
    }
    public void addBAceptarAl (ActionListener al){
        bAceptar.addActionListener(al);
    }
    public void addBAnadirEquipoAl (ActionListener al) {bAnadirEquipo.addActionListener(al);
    }
    public void addBEliminarEquipoAl (ActionListener al) {bEliminarEquipo.addActionListener(al);
    }
    public void addCbCompeticionesAl (ActionListener al){
        cbCompeticiones.addActionListener(al);
    }
    public void addBSalirAl (ActionListener al){
        bSalir.addActionListener(al);
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public JPanel getPanelComboBox() {
        return panelComboBox;
    }

    public void setPanelComboBox(JPanel panelComboBox) {
        this.panelComboBox = panelComboBox;
    }

    public JComboBox getCbCompeticiones() {
        return cbCompeticiones;
    }

    public void setCbCompeticiones(JComboBox cbCompeticiones) {
        this.cbCompeticiones = cbCompeticiones;
    }

    public JPanel getPanelDatos() {
        return panelDatos;
    }

    public void setPanelDatos(JPanel panelDatos) {
        this.panelDatos = panelDatos;
    }

    public JTextArea getTaDatos() {
        return taDatos;
    }

    public void setTaDatos(JTextArea taDatos) {
        this.taDatos = taDatos;
    }

    public JPanel getPanelCrear() {
        return panelCrear;
    }

    public void setPanelCrear(JPanel panelCrear) {
        this.panelCrear = panelCrear;
    }

    public JTextField getTfNombre() {
        return tfNombre;
    }

    public void setTfNombre(JTextField tfNombre) {
        this.tfNombre = tfNombre;
    }

    public JPanel getpFechaInicio() {
        return pFechaInicio;
    }

    public void setpFechaInicio(JPanel pFechaInicio) {
        this.pFechaInicio = pFechaInicio;
    }

    public JComboBox getCbAnadirEquipos() {
        return cbAnadirEquipos;
    }

    public void setCbAnadirEquipos(JComboBox cbAnadirEquipos) {
        this.cbAnadirEquipos = cbAnadirEquipos;
    }

    public JComboBox getCbEliminarEquipos() {
        return cbEliminarEquipos;
    }

    public void setCbEliminarEquipos(JComboBox cbEliminarEquipos) {
        this.cbEliminarEquipos = cbEliminarEquipos;
    }

    public JPanel getpFechaFin() {
        return pFechaFin;
    }

    public void setpFechaFin(JPanel pFechaFin) {
        this.pFechaFin = pFechaFin;
    }

    public JCalendar getcFechaInicio() {
        return cFechaInicio;
    }

    public void setcFechaInicio(JCalendar cFechaInicio) {
        this.cFechaInicio = cFechaInicio;
    }

    public JCalendar getcFechaFin() {
        return cFechaFin;
    }

    public void setcFechaFin(JCalendar cFechaFin) {
        this.cFechaFin = cFechaFin;
    }

    public void limpiar() {

    }
}