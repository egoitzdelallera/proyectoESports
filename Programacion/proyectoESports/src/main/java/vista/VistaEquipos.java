package vista;

import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Vista para la gestión de equipos.
 */
public class VistaEquipos extends JFrame{
    private JComboBox cbEquipos;
    private JTextArea taDatos;
    private JButton bEditar;
    private JButton bBorrar;
    private JTextField tfNombre;
    private JPanel pFecha;
    private JPanel panelPrincipal;
    private JPanel panelComboBox;
    private JPanel panelDatos;
    private JPanel panelCrear;
    private JButton bAceptar;
    private JButton bSalir;
    private JCalendar cFecha;

    /**
     * Constructor de la clase VistaEquipos.
     * Inicializa la vista de equipos.
     */
    public VistaEquipos() {
        super("Equipos");
        setContentPane(panelPrincipal);
        setSize(500,500);
        setLocationRelativeTo(null);
        cFecha = new JCalendar();
        pFecha.add(cFecha);
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
     * Agrega un ActionListener al botón de salir.
     *
     * @param al ActionListener a ser agregado.
     */
    public void addBSalirAl (ActionListener al){
        bSalir.addActionListener(al);
    }


    /**
     * Obtiene el JComboBox que muestra los equipos.
     *
     * @return JComboBox que muestra los equipos.
     */
    public JComboBox getCbEquipos() {
        return cbEquipos;
    }

    /**
     * Establece el JComboBox que muestra los equipos.
     *
     * @param cbEquipos JComboBox que muestra los equipos.
     */
    public void setCbEquipos(JComboBox cbEquipos) {
        this.cbEquipos = cbEquipos;
    }

    /**
     * Obtiene el JTextArea que muestra los datos del equipo seleccionado.
     *
     * @return JTextArea que muestra los datos del equipo seleccionado.
     */
    public JTextArea getTaDatos() {
        return taDatos;
    }

    /**
     * Establece el JTextArea que muestra los datos del equipo seleccionado.
     *
     * @param taDatos JTextArea que muestra los datos del equipo seleccionado.
     */
    public void setTaDatos(JTextArea taDatos) {
        this.taDatos = taDatos;
    }

    /**
     * Obtiene el JTextField para ingresar el nombre del equipo.
     *
     * @return JTextField para ingresar el nombre del equipo.
     */
    public JTextField getTfNombre() {
        return tfNombre;
    }

    /**
     * Establece el JTextField para ingresar el nombre del equipo.
     *
     * @param tfNombre JTextField para ingresar el nombre del equipo.
     */

    public void setTfNombre(JTextField tfNombre) {
        this.tfNombre = tfNombre;
    }

    /**
     * Obtiene el JPanel que contiene el componente de fecha.
     *
     * @return JPanel que contiene el componente de fecha.
     */
    public JPanel getpFecha() {
        return pFecha;
    }

    /**
     * Establece el JPanel que contiene el componente de fecha.
     *
     * @param pFecha JPanel que contiene el componente de fecha.
     */
    public void setpFecha(JPanel pFecha) {
        this.pFecha = pFecha;
    }

    /**
     * Obtiene el panel que contiene el JComboBox de equipos.
     *
     * @return JPanel que contiene el JComboBox de equipos.
     */
    public JPanel getPanelComboBox() {
        return panelComboBox;
    }

    /**
     * Establece el panel que contiene el JComboBox de equipos.
     *
     * @param panelComboBox JPanel que contiene el JComboBox de equipos.
     */
    public void setPanelComboBox(JPanel panelComboBox) {
        this.panelComboBox = panelComboBox;
    }

    /**
     * Obtiene el panel que muestra los datos del equipo seleccionado.
     *
     * @return JPanel que muestra los datos del equipo seleccionado.
     */
    public JPanel getPanelDatos() {
        return panelDatos;
    }

    /**
     * Establece el panel que muestra los datos del equipo seleccionado.
     *
     * @param panelDatos JPanel que muestra los datos del equipo seleccionado.
     */
    public void setPanelDatos(JPanel panelDatos) {
        this.panelDatos = panelDatos;
    }

    /**
     * Obtiene el panel para crear un nuevo equipo.
     *
     * @return JPanel para crear un nuevo equipo.
     */
    public JPanel getPanelCrear() {
        return panelCrear;
    }

    /**
     * Establece el panel para crear un nuevo equipo.
     *
     * @param panelCrear JPanel para crear un nuevo equipo.
     */
    public void setPanelCrear(JPanel panelCrear) {
        this.panelCrear = panelCrear;
    }

    /**
     * Obtiene el JCalendar para seleccionar la fecha del equipo.
     *
     * @return JCalendar para seleccionar la fecha del equipo.
     */
    public JCalendar getcFecha() {
        return cFecha;
    }

    /**
     * Establece el JCalendar para seleccionar la fecha del equipo.
     *
     * @param cFecha JCalendar para seleccionar la fecha del equipo.
     */
    public void setcFecha(JCalendar cFecha) {
        this.cFecha = cFecha;
    }

    /**
     * Método para limpiar los campos de entrada de la vista de equipos.
     */
    public void limpiar()
    {
        tfNombre.setText("");
        taDatos.setText("");
        tfNombre.requestFocus();
    }

    /**
     * Método para mostrar un mensaje en la ventana.
     *
     * @param m Mensaje a mostrar.
     */
    public void mostrarMensaje(String m)
    {

        JOptionPane.showMessageDialog(null, m);
    }



}
