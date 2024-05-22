package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VistaUsuarios extends JFrame {
    private JPanel panelPrincipal;
    private JPanel panelComboBox;
    private JComboBox cbUsuarios;
    private JPanel panelDatos;
    private JTextArea taDatos;
    private JButton bEditar;
    private JButton bBorrar;
    private JPanel panelCrear;
    private JTextField tfNombre;
    private JButton bAceptar;
    private JButton bSalir;
    private JTextField tfContrasena;
    private JRadioButton rbAdministrador;
    private JRadioButton rbUsuario;

    public VistaUsuarios() {
        super("Usuarios");
        setContentPane(panelPrincipal);
        setSize(500,500);
        setLocationRelativeTo(null);
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
    public void addCbUsuariosAl (ActionListener al){
        cbUsuarios.addActionListener(al);
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

    public JComboBox getCbUsuarios() {
        return cbUsuarios;
    }

    public void setCbUsuarios(JComboBox cbUsuarios) {
        this.cbUsuarios = cbUsuarios;
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

    public JTextField getTfContrasena() {
        return tfContrasena;
    }

    public void setTfContrasena(JTextField tfContrasena) {
        this.tfContrasena = tfContrasena;
    }

    public JRadioButton getRbAdministrador() {
        return rbAdministrador;
    }

    public void setRbAdministrador(JRadioButton rbAdministrador) {
        this.rbAdministrador = rbAdministrador;
    }

    public JRadioButton getRbUsuario() {
        return rbUsuario;
    }

    public void setRbUsuario(JRadioButton rbUsuario) {
        this.rbUsuario = rbUsuario;
    }

    public void limpiar() {
        tfNombre.setText("");
        tfContrasena.setText("");
        if(rbUsuario.isSelected()) rbUsuario.setSelected(false);
        if(rbAdministrador.isSelected()) rbAdministrador.setSelected(false);
    }
}
