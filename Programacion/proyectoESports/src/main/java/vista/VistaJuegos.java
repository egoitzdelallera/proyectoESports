package vista;
import com.toedter.calendar.JCalendar;


import javax.swing.*;
import java.awt.event.ActionListener;

import com.toedter.calendar.JCalendar;

/**
 * Vista para la gestión de juegos.
 */
public class VistaJuegos extends JFrame {
    private JPanel panelComboBox;
    private JComboBox cbJuegos;
    private JPanel panelDatos;
    private JTextArea taDatos;
    private JButton bEditar;
    private JButton bBorrar;
    private JPanel panelCrear;
    private JTextField tfNombre;
    private JPanel pFecha;
    private JButton bAceptar;
    private JTextField tfEmpresa;
    private JPanel panelPrincipal;
    private JButton bSalir;
    private JCalendar cFecha;

    /**
     * Constructor de la clase VistaJuegos.
     * Inicializa la vista de juegos.
     */
    public VistaJuegos() {
        super("Juegos");
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
     * Agrega un ActionListener al JComboBox de juegos.
     *
     * @param al ActionListener a ser agregado.
     */
    public void addCbJuegosAl (ActionListener al){
        cbJuegos.addActionListener(al);
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
     * Método para limpiar los campos de entrada de la vista de juegos.
     */
    public void limpiar()
    {
        tfNombre.setText("");
        tfEmpresa.setText("");
        taDatos.setText("");

    }

    /**
     * Obtiene el JPanel que contiene el JComboBox de juegos.
     *
     * @return JPanel que contiene el JComboBox de juegos.
     */
    public JPanel getPanelComboBox() {
        return panelComboBox;
    }

    /**
     * Obtiene el JComboBox que muestra los juegos.
     *
     * @return JComboBox que muestra los juegos.
     */
    public JComboBox getCbJuegos() {
        return cbJuegos;
    }

    /**
     * Obtiene el JPanel que muestra los datos del juego seleccionado.
     *
     * @return JPanel que muestra los datos del juego seleccionado.
     */
    public JPanel getPanelDatos() {
        return panelDatos;
    }

    /**
     * Obtiene el JTextArea que muestra los datos del juego seleccionado.
     *
     * @return JTextArea que muestra los datos del juego seleccionado.
     */
    public JTextArea getTaDatos() {
        return taDatos;
    }

    /**
     * Obtiene el JPanel para crear un nuevo juego.
     *
     * @return JPanel para crear un nuevo juego.
     */
    public JPanel getPanelCrear() {
        return panelCrear;
    }

    /**
     * Obtiene el JTextField para ingresar el nombre del juego.
     *
     * @return JTextField para ingresar el nombre del juego.
     */
    public JTextField getTfNombre() {
        return tfNombre;
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
     * Obtiene el JTextField para ingresar el nombre de la empresa del juego.
     *
     * @return JTextField para ingresar el nombre de la empresa del juego.
     */

    public JTextField getTfEmpresa() {
        return tfEmpresa;
    }

    /**
     * Obtiene el panel principal de la vista de juegos.
     *
     * @return JPanel que representa el panel principal de la vista.
     */
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    /**
     * Establece el JComboBox que muestra los juegos.
     *
     * @param cbJuegos JComboBox que muestra los juegos.
     */
    public void setCbJuegos(JComboBox cbJuegos) {
        this.cbJuegos = cbJuegos;
    }

    /**
     * Obtiene el JCalendar para seleccionar la fecha del juego.
     *
     * @return JCalendar para seleccionar la fecha del juego.
     */
    public JCalendar getcFecha() {
        return cFecha;
    }

    /**
     * Establece el JCalendar para seleccionar la fecha del juego.
     *
     * @param cFecha JCalendar para seleccionar la fecha del juego.
     */
    public void setcFecha(JCalendar cFecha) {
        this.cFecha = cFecha;
    }
}
