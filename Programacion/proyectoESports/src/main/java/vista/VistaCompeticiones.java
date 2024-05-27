package vista;

import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Clase que representa la vista de las competiciones.
 */
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


    /**
     * Constructor de la clase VistaCompeticiones.
     * Crea una nueva instancia de la ventana de competiciones.
     */
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
        taDatos.setDisabledTextColor(Color.black);
        taDatos.setSelectedTextColor(Color.black);
        taDatos.setSelectionColor(Color.white);
        cbCompeticiones.setBackground(Color.black);
        cbCompeticiones.setForeground(Color.white);
        cbAnadirEquipos.setBackground(Color.black);
        cbAnadirEquipos.setForeground(Color.white);
        cbJuego.setBackground(Color.black);
        cbJuego.setForeground(Color.white);
        cbEliminarEquipos.setBackground(Color.black);
        cbEliminarEquipos.setForeground(Color.black);
        chkEstado.setOpaque(false);
        chkEstado.setForeground(Color.white);
        bEditar.setBackground(Color.black);
        bEditar.setForeground(Color.white);
        bAnadirEquipo.setBackground(Color.black);
        bAnadirEquipo.setForeground(Color.white);
        bEliminarEquipo.setBackground(Color.black);
        bEliminarEquipo.setForeground(Color.white);
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
        cFechaFin.setForeground(Color.black);
        pFechaFin.setForeground(Color.black);
        tfNombre.setSelectionColor(Color.white);
        tfNombre.setSelectedTextColor(Color.black);

    }

    /**
     * Agrega un ActionListener al botón de editar.
     *
     * @param al ActionListener a agregar.
     */
    public void addBEditarAl (ActionListener al){
        bEditar.addActionListener(al);
    }

    /**
     * Agrega un ActionListener al botón de borrar.
     *
     * @param al ActionListener a agregar.
     */
    public void addBBorrarAl (ActionListener al){
        bBorrar.addActionListener(al);
    }

    /**
     * Agrega un ActionListener al botón de aceptar.
     *
     * @param al ActionListener a agregar.
     */
    public void addBAceptarAl (ActionListener al){
        bAceptar.addActionListener(al);
    }

    /**
     * Agrega un ActionListener al botón de añadir equipo.
     *
     * @param al ActionListener a agregar.
     */
    public void addBAnadirEquipoAl (ActionListener al) {bAnadirEquipo.addActionListener(al);
    }
    /**
     * Agrega un ActionListener al botón de eliminar equipo.
     *
     * @param al ActionListener a agregar.
     */

    public void addBEliminarEquipoAl (ActionListener al) {bEliminarEquipo.addActionListener(al);
    }

    /**
     * Agrega un ActionListener al JComboBox de competiciones.
     *
     * @param al ActionListener a agregar.
     */
    public void addCbCompeticionesAl (ActionListener al){
        cbCompeticiones.addActionListener(al);
    }

    /**
     * Agrega un ActionListener al botón de salir.
     *
     * @param al ActionListener a agregar.
     */
    public void addBSalirAl (ActionListener al){
        bSalir.addActionListener(al);
    }


    /**
     * Obtiene el JPanel principal.
     *
     * @return JPanel principal.
     */

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    /**
     * Establece el JPanel principal.
     *
     * @param panelPrincipal JPanel principal.
     */
    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    /**
     * Obtiene el JPanel que contiene el JComboBox de competiciones.
     *
     * @return JPanel que contiene el JComboBox de competiciones.
     */
    public JPanel getPanelComboBox() {
        return panelComboBox;
    }

    /**
     * Establece el JPanel que contiene el JComboBox de competiciones.
     *
     * @param panelComboBox JPanel que contiene el JComboBox de competiciones.
     */
    public void setPanelComboBox(JPanel panelComboBox) {
        this.panelComboBox = panelComboBox;
    }

    /**
     * Obtiene el JComboBox de competiciones.
     *
     * @return JComboBox de competiciones.
     */
    public JComboBox getCbCompeticiones() {
        return cbCompeticiones;
    }

    /**
     * Establece el JComboBox de competiciones.
     *
     * @param cbCompeticiones JComboBox de competiciones.
     */
    public void setCbCompeticiones(JComboBox cbCompeticiones) {
        this.cbCompeticiones = cbCompeticiones;
    }

    /**
     * Obtiene el JPanel que contiene los datos.
     *
     * @return JPanel que contiene los datos.
     */
    public JPanel getPanelDatos() {
        return panelDatos;
    }

    /**
     * Establece el JPanel que contiene los datos.
     *
     * @param panelDatos JPanel que contiene los datos.
     */
    public void setPanelDatos(JPanel panelDatos) {
        this.panelDatos = panelDatos;
    }

    /**
     * Obtiene el JTextArea que muestra los datos.
     *
     * @return JTextArea que muestra los datos.
     */
    public JTextArea getTaDatos() {
        return taDatos;
    }

    /**
     * Establece el JTextArea que muestra los datos.
     *
     * @param taDatos JTextArea que muestra los datos.
     */
    public void setTaDatos(JTextArea taDatos) {
        this.taDatos = taDatos;
    }

    /**
     * Obtiene el JPanel que permite crear una nueva competición.
     *
     * @return JPanel para crear una nueva competición.
     */
    public JPanel getPanelCrear() {
        return panelCrear;
    }

    /**
     * Establece el JPanel que permite crear una nueva competición.
     *
     * @param panelCrear JPanel para crear una nueva competición.
     */
    public void setPanelCrear(JPanel panelCrear) {
        this.panelCrear = panelCrear;
    }

    /**
     * Obtiene el JTextField que permite ingresar el nombre de la competición.
     *
     * @return JTextField para ingresar el nombre de la competición.
     */
    public JTextField getTfNombre() {
        return tfNombre;
    }

    /**
     * Establece el JTextField que permite ingresar el nombre de la competición.
     *
     * @param tfNombre JTextField para ingresar el nombre de la competición.
     */
    public void setTfNombre(JTextField tfNombre) {
        this.tfNombre = tfNombre;
    }

    /**
     * Obtiene el JPanel que contiene el calendario de fecha de inicio.
     *
     * @return JPanel que contiene el calendario de fecha de inicio.
     */
    public JPanel getpFechaInicio() {
        return pFechaInicio;
    }

    /**
     * Establece el JPanel que contiene el calendario de fecha de inicio.
     *
     * @param pFechaInicio JPanel que contiene el calendario de fecha de inicio.
     */
    public void setpFechaInicio(JPanel pFechaInicio) {
        this.pFechaInicio = pFechaInicio;
    }

    /**
     * Obtiene el JComboBox que permite seleccionar un equipo para añadir a la competición.
     *
     * @return JComboBox para añadir un equipo a la competición.
     */
    public JComboBox getCbAnadirEquipos() {
        return cbAnadirEquipos;
    }

    /**
     * Establece el JComboBox que permite seleccionar un equipo para añadir a la competición.
     *
     * @param cbAnadirEquipos JComboBox para añadir un equipo a la competición.
     */
    public void setCbAnadirEquipos(JComboBox cbAnadirEquipos) {
        this.cbAnadirEquipos = cbAnadirEquipos;
    }

    /**
     * Obtiene el JComboBox que permite seleccionar un equipo para eliminar de la competición.
     *
     * @return JComboBox para eliminar un equipo de la competición.
     */
    public JComboBox getCbEliminarEquipos() {
        return cbEliminarEquipos;
    }

    /**
     * Establece el JComboBox que permite seleccionar un equipo para eliminar de la competición.
     *
     * @param cbEliminarEquipos JComboBox para eliminar un equipo de la competición.
     */
    public void setCbEliminarEquipos(JComboBox cbEliminarEquipos) {
        this.cbEliminarEquipos = cbEliminarEquipos;
    }

    /**
     * Obtiene el JPanel que representa la fecha de fin de la competición.
     *
     * @return Panel para la fecha de fin de la competición.
     */
    public JPanel getpFechaFin() {
        return pFechaFin;
    }

    /**
     * Establece el JPanel que representa la fecha de fin de la competición.
     *
     * @return Panel para la fecha de fin de la competición.
     */
    public void setpFechaFin(JPanel pFechaFin) {
        this.pFechaFin = pFechaFin;
    }

    /**
     * Obtiene el JCalendar que representa la fecha de inicio de la competición.
     *
     * @return JCalendar para la fecha de inicio de la competición.
     */
    public JCalendar getcFechaInicio() {
        return cFechaInicio;
    }

    /**
     * Establece el JCalendar que representa la fecha de inicio de la competición.
     *
     * @param cFechaInicio JCalendar para la fecha de inicio de la competición.
     */
    public void setcFechaInicio(JCalendar cFechaInicio) {
        this.cFechaInicio = cFechaInicio;
    }

    /**
     * Obtiene el JCalendar que representa la fecha de fin de la competición.
     *
     * @return JCalendar para la fecha de fin de la competición.
     */
    public JCalendar getcFechaFin() {
        return cFechaFin;
    }

    /**
     * Establece el JCalendar que representa la fecha de fin de la competición.
     *
     * @param cFechaFin JCalendar para la fecha de fin de la competición.
     */
    public void setcFechaFin(JCalendar cFechaFin) {
        this.cFechaFin = cFechaFin;
    }

    /**
     * Obtiene el JCheckBox que indica el estado de la competición.
     *
     * @return JCheckBox para el estado de la competición.
     */
    public JCheckBox getChkEstado() {
        return chkEstado;
    }

    /**
     * Establece el JCheckBox que indica el estado de la competición.
     *
     * @param chkEstado JCheckBox para el estado de la competición.
     */
    public void setChkEstado(JCheckBox chkEstado) {
        this.chkEstado = chkEstado;
    }

    /**
     * Obtiene el JComboBox que permite seleccionar el juego asociado a la competición.
     *
     * @return JComboBox para seleccionar el juego asociado a la competición.
     */
    public JComboBox getCbJuego() {
        return cbJuego;
    }

    /**
     * Establece el JComboBox que permite seleccionar el juego asociado a la competición.
     *
     * @param cbJuego JComboBox para seleccionar el juego asociado a la competición.
     */
    public void setCbJuego(JComboBox cbJuego) {
        this.cbJuego = cbJuego;
    }

    /**
     * Metodo para limpiar los campos de entrada de la vista de competiciones.
     */
    public void limpiar() {

    }
}