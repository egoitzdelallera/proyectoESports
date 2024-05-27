

package vista;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;

public class VistaJugadores extends JFrame{
    private JPanel panelPrincipal;
    private JPanel panelComboBox;
    private JComboBox cbJugadores;
    private JPanel panelDatos;
    private JTextArea taDatos;
    private JButton bEditar;
    private JButton bBorrar;
    private JPanel panelCrear;
    private JTextField tfNombre;
    private JPanel pFecha;
    private JButton bAceptar;
    private JButton bSalir;
    private JTextField tfNacionalidad;
    private JTextField tfNickname;
    private JTextField tfRol;
    private JTextField tfSueldo;
    private JComboBox cbEquipos;
    private JCalendar cFecha;



    public VistaJugadores() {
        super("Jugadores");
        setContentPane(panelPrincipal);
        setSize(500,1000);
        setLocationRelativeTo(null);
        cFecha = new JCalendar();
        pFecha.add(cFecha);
        panelPrincipal.setBackground(Color.black);
        panelComboBox.setOpaque(false);
        panelCrear.setOpaque(false);
        panelDatos.setOpaque(false );
        taDatos.setEnabled(false);
        taDatos.setDisabledTextColor(Color.black);
        taDatos.setSelectedTextColor(Color.black);
        taDatos.setSelectionColor(Color.white);
        cbJugadores.setBackground(Color.black);
        cbJugadores.setForeground(Color.white);
        bEditar.setBackground(Color.black);
        bEditar.setForeground(Color.white);
        bAceptar.setForeground(Color.white);
        bAceptar.setBackground(Color.black);
        bBorrar.setForeground(Color.white);
        bBorrar.setBackground(Color.black);
        bSalir.setForeground(Color.white);
        bSalir.setBackground(Color.black);
        tfNombre.setBackground(Color.black);
        tfNombre.setForeground(Color.white);
        pFecha.setOpaque(false);
        pFecha.setBackground(Color.black);
        cFecha.setBackground(Color.black);
        cFecha.setForeground(Color.white);
        pFecha.setForeground(Color.white);
        tfNombre.setSelectionColor(Color.white);
        tfNombre.setSelectedTextColor(Color.black);
        tfNacionalidad.setBackground(Color.black);
        tfNacionalidad.setForeground(Color.white);
        tfNacionalidad.setSelectionColor(Color.white);
        tfNacionalidad.setSelectedTextColor(Color.black);
        tfNickname.setBackground(Color.black);
        tfNickname.setForeground(Color.white);
        tfNickname.setSelectionColor(Color.white);
        tfNickname.setSelectedTextColor(Color.black);
        tfSueldo.setBackground(Color.black);
        tfSueldo.setForeground(Color.white);
        tfSueldo.setSelectionColor(Color.white);
        tfSueldo.setSelectedTextColor(Color.black);
        tfRol.setBackground(Color.black);
        tfRol.setForeground(Color.white);
        tfRol.setSelectionColor(Color.white);
        tfRol.setSelectedTextColor(Color.black);
        cbEquipos.setBackground(Color.black);
        cbEquipos.setForeground(Color.white);
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
    public void addCbJugadoresAl (ActionListener al){
        cbJugadores.addActionListener(al);
    }
    public void addBSalirAl (ActionListener al){
        bSalir.addActionListener(al);
    }


    public void limpiar()
    {
        tfNombre.setText("");
        tfNacionalidad.setText("");
        tfNickname.setText("");
        tfRol.setText("");
        tfSueldo.setText("");
        cbEquipos.setSelectedItem(0);
        taDatos.setText("");
        tfNombre.requestFocus();
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

    public JComboBox getCbJugadores() {
        return cbJugadores;
    }

    public void setCbJugadores(JComboBox cbJugadores) {
        this.cbJugadores = cbJugadores;
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

    public JPanel getpFecha() {
        return pFecha;
    }

    public void setpFecha(JPanel pFecha) {
        this.pFecha = pFecha;
    }

    public JTextField getTfNacionalidad() {
        return tfNacionalidad;
    }

    public void setTfNacionalidad(JTextField tfNacionalidad) {
        this.tfNacionalidad = tfNacionalidad;
    }

    public JTextField getTfNickname() {
        return tfNickname;
    }

    public void setTfNickname(JTextField tfNickname) {
        this.tfNickname = tfNickname;
    }

    public JTextField getTfRol() {
        return tfRol;
    }

    public void setTfRol(JTextField tfRol) {
        this.tfRol = tfRol;
    }

    public JTextField getTfSueldo() {
        return tfSueldo;
    }

    public void setTfSueldo(JTextField tfSueldo) {
        this.tfSueldo = tfSueldo;
    }

    public JComboBox getCbEquipos() {
        return cbEquipos;
    }

    public void setCbEquipos(JComboBox cbEquipo) {
        this.cbEquipos = cbEquipo;
    }


    public JCalendar getcFecha() {
        return cFecha;
    }

    public void setcFecha(JCalendar cFecha) {
        this.cFecha = cFecha;
    }


}
