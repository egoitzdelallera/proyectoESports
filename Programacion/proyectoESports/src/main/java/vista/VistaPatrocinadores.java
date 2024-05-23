package vista;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VistaPatrocinadores extends JFrame{
    private JPanel panelComboBox;
    private JComboBox cbPatrocinadores;
    private JPanel panelDatos;
    private JTextArea taDatos;
    private JButton bEditar;
    private JButton bBorrar;
    private JPanel panelCrear;
    private JTextField tfNombre;
    private JButton bAceptar;
    private JButton bSalir;
    private JComboBox cbEquipos;
    private JPanel panelPrincipal;
    private JList lEquipos;

    public VistaPatrocinadores() {
        super("Patrocinadores");
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
    public void addCbEquiposAl (ActionListener al){
        cbEquipos.addActionListener(al);
    }
    public void addCbPatrocinadoresAl (ActionListener al){
        cbPatrocinadores.addActionListener(al);
    }
    public void addBSalirAl (ActionListener al){
        bSalir.addActionListener(al);
    }
    public void limpiar()
    {
        tfNombre.setText("");
        tfNombre.requestFocus();
    }

    public JPanel getPanelComboBox() {
        return panelComboBox;
    }

    public void setPanelComboBox(JPanel panelComboBox) {
        this.panelComboBox = panelComboBox;
    }

    public JComboBox getCbPatrocinadores() {
        return cbPatrocinadores;
    }

    public void setCbPatrocinadores(JComboBox cbPatrocinadores) {
        this.cbPatrocinadores = cbPatrocinadores;
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

    public JComboBox getCbEquipos() {
        return cbEquipos;
    }

    public void setCbEquipos(JComboBox cbEquipos) {
        this.cbEquipos = cbEquipos;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public JList getlEquipos() {
        return lEquipos;
    }

    public void setlEquipos(JList lEquipos) {
        this.lEquipos = lEquipos;
    }
}
