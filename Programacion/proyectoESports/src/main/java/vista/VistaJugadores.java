

package vista;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Vista para la gestión de jugadores.
 */
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
    private JDateChooser dateChooser;


    /**
     * Constructor de la clase VistaJugadores.
     * Inicializa la vista de jugadores.
     */
    public VistaJugadores() {
        super("Jugadores");
        setContentPane(panelPrincipal);
        setSize(500,1000);
        setLocationRelativeTo(null);
        cFecha = new JCalendar();
        pFecha.add(cFecha);
        dateChooser = new JDateChooser();
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
     * Agrega un ActionListener al JComboBox de jugadores.
     *
     * @param al ActionListener a ser agregado.
     */
    public void addCbJugadoresAl (ActionListener al){
        cbJugadores.addActionListener(al);
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
     * Método para limpiar los campos de entrada de la vista de jugadores.
     */
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

    /**
     * Obtiene el JPanel principal de la vista de jugadores.
     *
     * @return JPanel principal de la vista.
     */
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    /**
     * Establece el JPanel principal de la vista de jugadores.
     *
     * @param panelPrincipal JPanel principal de la vista.
     */
    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    /**
     * Obtiene el JPanel que contiene el JComboBox de jugadores.
     *
     * @return JPanel que contiene el JComboBox de jugadores.
     */
    public JPanel getPanelComboBox() {
        return panelComboBox;
    }

    /**
     * Establece el JPanel que contiene el JComboBox de jugadores.
     *
     * @param panelComboBox JPanel que contiene el JComboBox de jugadores.
     */
    public void setPanelComboBox(JPanel panelComboBox) {
        this.panelComboBox = panelComboBox;
    }

    /**
     * Obtiene el JComboBox que muestra los jugadores.
     *
     * @return JComboBox que muestra los jugadores.
     */
    public JComboBox getCbJugadores() {
        return cbJugadores;
    }

    /**
     * Establece el JComboBox que muestra los jugadores.
     *
     * @param cbJugadores JComboBox que muestra los jugadores.
     */
    public void setCbJugadores(JComboBox cbJugadores) {
        this.cbJugadores = cbJugadores;
    }

    /**
     * Obtiene el JPanel que muestra los datos del jugador seleccionado.
     *
     * @return JPanel que muestra los datos del jugador seleccionado.
     */
    public JPanel getPanelDatos() {
        return panelDatos;
    }

    /**
     * Establece el JPanel que muestra los datos del jugador seleccionado.
     *
     * @param panelDatos JPanel que muestra los datos del jugador seleccionado.
     */
    public void setPanelDatos(JPanel panelDatos) {
        this.panelDatos = panelDatos;
    }

    /**
     * Obtiene el JTextArea que muestra los datos del jugador seleccionado.
     *
     * @return JTextArea que muestra los datos del jugador seleccionado.
     */
    public JTextArea getTaDatos() {
        return taDatos;
    }

    /**
     * Establece el JTextArea que muestra los datos del jugador seleccionado.
     *
     * @param taDatos JTextArea que muestra los datos del jugador seleccionado.
     */
    public void setTaDatos(JTextArea taDatos) {
        this.taDatos = taDatos;
    }

    /**
     * Obtiene el JPanel para crear un nuevo jugador.
     *
     * @return JPanel para crear un nuevo jugador.
     */
    public JPanel getPanelCrear() {
        return panelCrear;
    }


    /**
     * Establece el JPanel para crear un nuevo jugador.
     *
     * @param panelCrear JPanel para crear un nuevo jugador.
     */
    public void setPanelCrear(JPanel panelCrear) {
        this.panelCrear = panelCrear;
    }

    /**
     * Obtiene el JTextField para ingresar el nombre del jugador.
     *
     * @return JTextField para ingresar el nombre del jugador.
     */
    public JTextField getTfNombre() {
        return tfNombre;
    }

    /**
     * Establece el JTextField para ingresar el nombre del jugador.
     *
     * @param tfNombre JTextField para ingresar el nombre del jugador.
     */
    public void setTfNombre(JTextField tfNombre) {
        this.tfNombre = tfNombre;
    }

    /**
     * Obtiene el JPanel que contiene el componente de fecha de nacimiento.
     *
     * @return JPanel que contiene el componente de fecha de nacimiento.
     */
    public JPanel getpFecha() {
        return pFecha;
    }

    /**
     * Establece el JPanel que contiene el componente de fecha de nacimiento.
     *
     * @param pFecha JPanel que contiene el componente de fecha de nacimiento.
     */
    public void setpFecha(JPanel pFecha) {
        this.pFecha = pFecha;
    }

    /**
     * Obtiene el JTextField para ingresar la nacionalidad del jugador.
     *
     * @return JTextField para ingresar la nacionalidad del jugador.
     */
    public JTextField getTfNacionalidad() {
        return tfNacionalidad;
    }

    /**
     * Establece el JTextField para ingresar la nacionalidad del jugador.
     *
     * @param tfNacionalidad JTextField para ingresar la nacionalidad del jugador.
     */
    public void setTfNacionalidad(JTextField tfNacionalidad) {
        this.tfNacionalidad = tfNacionalidad;
    }

    /**
     * Obtiene el JTextField para ingresar el nickname del jugador.
     *
     * @return JTextField para ingresar el nickname del jugador.
     */
    public JTextField getTfNickname() {
        return tfNickname;
    }

    /**
     * Establece el JTextField para ingresar el nickname del jugador.
     *
     * @param tfNickname JTextField para ingresar el nickname del jugador.
     */
    public void setTfNickname(JTextField tfNickname) {
        this.tfNickname = tfNickname;
    }

    /**
     * Obtiene el JTextField para ingresar el rol del jugador.
     *
     * @return JTextField para ingresar el rol del jugador.
     */
    public JTextField getTfRol() {
        return tfRol;
    }

    /**
     * Establece el JTextField para ingresar el rol del jugador.
     *
     * @param tfRol JTextField para ingresar el rol del jugador.
     */
    public void setTfRol(JTextField tfRol) {
        this.tfRol = tfRol;
    }

    /**
     * Obtiene el JTextField para ingresar el sueldo del jugador.
     *
     * @return JTextField para ingresar el sueldo del jugador.
     */
    public JTextField getTfSueldo() {
        return tfSueldo;
    }

    /**
     * Establece el JTextField para ingresar el sueldo del jugador.
     *
     * @param tfSueldo JTextField para ingresar el sueldo del jugador.
     */
    public void setTfSueldo(JTextField tfSueldo) {
        this.tfSueldo = tfSueldo;
    }


    /**
     * Obtiene el JComboBox para seleccionar el equipo del jugador.
     *
     * @return JComboBox para seleccionar el equipo del jugador.
     */
    public JComboBox getCbEquipos() {
        return cbEquipos;
    }


    /**
     * Establece el JComboBox para seleccionar el equipo del jugador.
     *
     * @param cbEquipo JComboBox para seleccionar el equipo del jugador.
     */
    public void setCbEquipos(JComboBox cbEquipo) {
        this.cbEquipos = cbEquipo;
    }


    /**
     * Obtiene el JCalendar para seleccionar la fecha de nacimiento del jugador.
     *
     * @return JCalendar para seleccionar la fecha de nacimiento del jugador.
     */
    public JCalendar getcFecha() {
        return cFecha;
    }

    /**
     * Establece el JCalendar para seleccionar la fecha de nacimiento del jugador.
     *
     * @param cFecha JCalendar para seleccionar la fecha de nacimiento del jugador.
     */
    public void setcFecha(JCalendar cFecha) {
        this.cFecha = cFecha;
    }


}
