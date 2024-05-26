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
    private JCheckBox chkEstado;
    private JComboBox cbJuego;
    private JCalendar cFechaInicio;
    private JCalendar cFechaFin;


    public VistaCompeticiones() {
        super("Competiciones");
        setContentPane(panelPrincipal);
        setSize(1000,1000);
        setLocationRelativeTo(null);
        cFechaInicio = new JCalendar();
        cFechaFin = new JCalendar();
        pFechaInicio.add(cFechaInicio);
        pFechaFin.add(cFechaFin);
        panelPrincipal.setBackground(Color.black);
        panelComboBox.setOpaque(false);
        panelCrear.setOpaque(false);
        panelDatos.setOpaque(false );
        taDatos.setEnabled(false);
        taDatos.setDisabledTextColor(Color.white);
        taDatos.setSelectedTextColor(Color.black);
        taDatos.setSelectionColor(Color.white);
        cbCompeticiones.setBackground(Color.black);
        cbCompeticiones.setForeground(Color.black);
        cbAnadirEquipos.setBackground(Color.black);
        cbAnadirEquipos.setForeground(Color.black);
        cbJuego.setBackground(Color.black);
        cbJuego.setForeground(Color.black);
        cbEliminarEquipos.setBackground(Color.black);
        cbEliminarEquipos.setForeground(Color.black);
        chkEstado.setOpaque(false);
        chkEstado.setForeground(Color.white);
        bEditar.setBackground(Color.black);
        bEditar.setForeground(Color.white);
        bAceptar.setForeground(Color.white);
        bAceptar.setBackground(Color.black);
        bSalir.setForeground(Color.white);
        bSalir.setBackground(Color.black);
        tfNombre.setBackground(Color.black);
        tfNombre.setForeground(Color.white);
        pFechaInicio.setOpaque(false);
        pFechaInicio.setBackground(Color.black);
        cFechaInicio.setBackground(Color.black);
        cFechaInicio.setForeground(Color.white);
        pFechaInicio.setForeground(Color.white);
        pFechaFin.setOpaque(false);
        pFechaFin.setBackground(Color.black);
        cFechaFin.setBackground(Color.black);
        cFechaFin.setForeground(Color.white);
        pFechaFin.setForeground(Color.white);
        tfNombre.setSelectionColor(Color.white);
        tfNombre.setSelectedTextColor(Color.black);
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
    public void addBEstadoAl (ActionListener al){
        chkEstado.addActionListener(al);
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

    public JCheckBox getChkEstado() {
        return chkEstado;
    }

    public void setChkEstado(JCheckBox chkEstado) {
        this.chkEstado = chkEstado;
    }

    public JComboBox getCbJuego() {
        return cbJuego;
    }

    public void setCbJuego(JComboBox cbJuego) {
        this.cbJuego = cbJuego;
    }

    public void limpiar() {

    }
}