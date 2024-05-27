package vista;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Vista para la gestión de miembros de staff.
 */
public class VistaStaff extends JFrame {
    private JPanel panelComboBox;
    private JComboBox cbStaff;
    private JPanel panelPrincipal;
    private JPanel panelDatos;
    private JTextArea taDatos;
    private JButton bEditar;
    private JButton bBorrar;
    private JPanel panelCrear;
    private JTextField tfNombre;
    private JButton bAceptar;
    private JButton bSalir;
    private JTextField tfPuesto;
    private JTextField tfSueldo;
    private JComboBox cbEquipos;

    /**
     * Constructor de la clase VistaStaff.
     * Inicializa la vista del personal de staff.
     */
    public VistaStaff(){
        super("Staff");
        setContentPane(panelPrincipal);
        setSize(600,500);
        setLocationRelativeTo(null);


        panelPrincipal.setBackground(Color.black);
        panelComboBox.setOpaque(false);
        panelCrear.setOpaque(false);
        panelDatos.setOpaque(false );
        taDatos.setEnabled(false);
        taDatos.setDisabledTextColor(Color.black);
        taDatos.setSelectedTextColor(Color.black);
        taDatos.setSelectionColor(Color.white);
        cbStaff.setBackground(Color.black);
        cbStaff.setForeground(Color.white);
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
        tfNombre.setSelectionColor(Color.white);
        tfNombre.setSelectedTextColor(Color.black);
        tfSueldo.setBackground(Color.black);
        tfSueldo.setForeground(Color.white);
        tfSueldo.setSelectionColor(Color.white);
        tfSueldo.setSelectedTextColor(Color.black);
        tfPuesto.setBackground(Color.black);
        tfPuesto.setForeground(Color.white);
        tfPuesto.setSelectionColor(Color.white);
        tfPuesto.setSelectedTextColor(Color.black);
        cbEquipos.setBackground(Color.black);
        cbEquipos.setForeground(Color.white);

    }

    /**
     * Agrega un ActionListener al botón de editar.
     *
     * @param al ActionListener a ser agregado.
     */
    public void addBEditarAl (ActionListener al){
        bEditar.addActionListener(al);
    }

    /**
     * Agrega un ActionListener al botón de borrar.
     *
     * @param al ActionListener a ser agregado.
     */
    public void addBBorrarAl (ActionListener al){
        bBorrar.addActionListener(al);
    }

    /**
     * Agrega un ActionListener al botón de aceptar.
     *
     * @param al ActionListener a ser agregado.
     */
    public void addBAceptarAl (ActionListener al){
        bAceptar.addActionListener(al);
    }

    /**
     * Agrega un ActionListener al JComboBox de equipos.
     *
     * @param al ActionListener a ser agregado.
     */
    public void addCbEquiposAl (ActionListener al){
        cbEquipos.addActionListener(al);
    }

    /**
     * Agrega un ActionListener al JComboBox de staff.
     *
     * @param al ActionListener a ser agregado.
     */
    public void addCbStaffAl (ActionListener al){
        cbStaff.addActionListener(al);
    }

    /**
     * Agrega un ActionListener al botón de salir.
     *
     * @param al ActionListener a ser agregado.
     */
    public void addBSalirAl (ActionListener al){
        bSalir.addActionListener(al);
    }

    /**
     * Limpia los campos de texto y restablece la selección del JComboBox.
     */
    public void limpiar()
    {
        tfNombre.setText("");
        tfSueldo.setText("");
        cbEquipos.setSelectedItem(0);
        taDatos.setText("");
        tfNombre.requestFocus();
    }

    /**
     * Obtiene el panel del JComboBox.
     *
     * @return JPanel del JComboBox.
     */
    public JPanel getPanelComboBox() {
        return panelComboBox;
    }

    /**
     * Establece el panel del JComboBox.
     *
     * @param panelComboBox JPanel del JComboBox a ser establecido.
     */
    public void setPanelComboBox(JPanel panelComboBox) {
        this.panelComboBox = panelComboBox;
    }

    /**
     * Obtiene el JComboBox del staff.
     *
     * @return JComboBox del staff.
     */
    public JComboBox getCbStaff() {
        return cbStaff;
    }

    /**
     * Establece el JComboBox del staff.
     *
     * @param cbStaff JComboBox del staff a ser establecido.
     */
    public void setCbStaff(JComboBox cbStaff) {
        this.cbStaff = cbStaff;
    }

    /**
     * Obtiene el panel principal.
     *
     * @return JPanel principal.
     */
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    /**
     * Establece el panel principal.
     *
     * @param panelPrincipal JPanel principal a ser establecido.
     */
    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    /**
     * Obtiene el panel de datos.
     *
     * @return JPanel de datos.
     */
    public JPanel getPanelDatos() {
        return panelDatos;
    }

    /**
     * Establece el panel de datos.
     *
     * @param panelDatos JPanel de datos a ser establecido.
     */
    public void setPanelDatos(JPanel panelDatos) {
        this.panelDatos = panelDatos;
    }

    /**
     * Obtiene el JTextArea de datos.
     *
     * @return JTextArea de datos.
     */
    public JTextArea getTaDatos() {
        return taDatos;
    }

    /**
     * Establece el JTextArea de datos.
     *
     * @param taDatos JTextArea de datos a ser establecido.
     */
    public void setTaDatos(JTextArea taDatos) {
        this.taDatos = taDatos;
    }

    /**
     * Obtiene el panel de creación.
     *
     * @return JPanel de creación.
     */
    public JPanel getPanelCrear() {
        return panelCrear;
    }

    /**
     * Establece el panel de creación.
     *
     * @param panelCrear JPanel de creación a ser establecido.
     */
    public void setPanelCrear(JPanel panelCrear) {
        this.panelCrear = panelCrear;
    }

    /**
     * Obtiene el JTextField del nombre.
     *
     * @return JTextField del nombre.
     */
    public JTextField getTfNombre() {
        return tfNombre;
    }

    /**
     * Establece el JTextField del nombre.
     *
     * @param tfNombre JTextField del nombre a ser establecido.
     */
    public void setTfNombre(JTextField tfNombre) {
        this.tfNombre = tfNombre;
    }

    /**
     * Obtiene el JTextField del puesto.
     *
     * @return JTextField del puesto.
     */
    public JTextField getTfPuesto() {
        return tfPuesto;
    }

    /**
     * Establece el JTextField del puesto.
     *
     * @param tfPuesto JTextField del puesto a ser establecido.
     */
    public void setTfPuesto(JTextField tfPuesto) {
        this.tfPuesto = tfPuesto;
    }

    /**
     * Obtiene el JTextField del sueldo.
     *
     * @return JTextField del sueldo.
     */
    public JTextField getTfSueldo() {
        return tfSueldo;
    }

    /**
     * Establece el JTextField del sueldo.
     *
     * @param tfSueldo JTextField del sueldo a ser establecido.
     */
    public void setTfSueldo(JTextField tfSueldo) {
        this.tfSueldo = tfSueldo;
    }

    /**
     * Obtiene el JComboBox de equipos.
     *
     * @return JComboBox de equipos.
     */
    public JComboBox getCbEquipos() {
        return cbEquipos;
    }

    /**
     * Establece el JComboBox de equipos.
     *
     * @param cbEquipos JComboBox de equipos a ser establecido.
     */
    public void setCbEquipos(JComboBox cbEquipos) {
        this.cbEquipos = cbEquipos;
    }

}
