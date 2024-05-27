package vista;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * La clase VistaPatrocinadores representa la interfaz gráfica de usuario (GUI)
 * para la gestión de patrocinadores en una aplicación.
 * Hereda de JFrame para crear una ventana principal.
 */
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

    /**
     * Constructor de la clase VistaPatrocinadores.
     * Inicializa la ventana con el título "Patrocinadores" y configura su tamaño y ubicación.
     */
    public VistaPatrocinadores() {
        super("Patrocinadores");
        setContentPane(panelPrincipal);
        setSize(500,500);
        setLocationRelativeTo(null);
    }

    /**
     * Agrega un ActionListener al botón "Editar".
     * @param al el ActionListener a agregar
     */
    public void addBEditarAl (ActionListener al){
        bEditar.addActionListener(al);
    }
    /**
     * Agrega un ActionListener al botón "Borrar".
     * @param al el ActionListener a agregar
     */
    public void addBBorrarAl (ActionListener al){
        bBorrar.addActionListener(al);
    }
    /**
     * Agrega un ActionListener al botón "Aceptar".
     * @param al el ActionListener a agregar
     */
    public void addBAceptarAl (ActionListener al){
        bAceptar.addActionListener(al);
    }
    /**
     * Agrega un ActionListener al JComboBox de equipos.
     * @param al el ActionListener a agregar
     */
    public void addCbEquiposAl (ActionListener al){
        cbEquipos.addActionListener(al);
    }

    /**
     * Agrega un ActionListener al JComboBox de patrocinadores.
     * @param al el ActionListener a agregar
     */
    public void addCbPatrocinadoresAl (ActionListener al){
        cbPatrocinadores.addActionListener(al);
    }
    /**
     * Agrega un ActionListener al botón "Salir".
     * @param al el ActionListener a agregar
     */
    public void addBSalirAl (ActionListener al){
        bSalir.addActionListener(al);
    }
    /**
     * Limpia el campo de texto del nombre del patrocinador.
     */
    public void limpiar()
    {
        tfNombre.setText("");
        tfNombre.requestFocus();
    }

    /**
     * Obtiene el panel que contiene el JComboBox de patrocinadores.
     * @return el panel de JComboBox
     */
    public JPanel getPanelComboBox() {
        return panelComboBox;
    }

    /**
     * Establece el panel que contiene el JComboBox de patrocinadores.
     * @param panelComboBox el panel de JComboBox a establecer
     */
    public void setPanelComboBox(JPanel panelComboBox) {
        this.panelComboBox = panelComboBox;
    }


    /**
     * Obtiene el JComboBox de patrocinadores.
     * @return el JComboBox de patrocinadores
     */
    public JComboBox getCbPatrocinadores() {
        return cbPatrocinadores;
    }

    /**
     * Establece el JComboBox de patrocinadores.
     * @param cbPatrocinadores el JComboBox de patrocinadores a establecer
     */
    public void setCbPatrocinadores(JComboBox cbPatrocinadores) {
        this.cbPatrocinadores = cbPatrocinadores;
    }

    /**
     * Obtiene el panel que contiene los datos del patrocinador.
     * @return el panel de datos
     */
    public JPanel getPanelDatos() {
        return panelDatos;
    }

    /**
     * Establece el panel que contiene los datos del patrocinador.
     * @param panelDatos el panel de datos a establecer
     */
    public void setPanelDatos(JPanel panelDatos) {
        this.panelDatos = panelDatos;
    }

    /**
     * Obtiene el JTextArea que muestra los datos del patrocinador.
     * @return el JTextArea de datos
     */
    public JTextArea getTaDatos() {
        return taDatos;
    }

    /**
     * Establece el JTextArea que muestra los datos del patrocinador.
     * @param taDatos el JTextArea de datos a establecer
     */
    public void setTaDatos(JTextArea taDatos) {
        this.taDatos = taDatos;
    }


    /**
     * Obtiene el panel que contiene los componentes para crear un patrocinador.
     * @return el panel de creación
     */public JPanel getPanelCrear() {
        return panelCrear;
    }

    /**
     * Establece el panel que contiene los componentes para crear un patrocinador.
     * @param panelCrear el panel de creación a establecer
     */
    public void setPanelCrear(JPanel panelCrear) {
        this.panelCrear = panelCrear;
    }

    /**
     * Obtiene el JTextField para el nombre del patrocinador.
     * @return el JTextField del nombre
     */
    public JTextField getTfNombre() {
        return tfNombre;
    }

    /**
     * Establece el JTextField para el nombre del patrocinador.
     * @param tfNombre el JTextField del nombre a establecer
     */
    public void setTfNombre(JTextField tfNombre) {
        this.tfNombre = tfNombre;
    }

    /**
     * Obtiene el JComboBox de equipos.
     * @return el JComboBox de equipos
     */
    public JComboBox getCbEquipos() {
        return cbEquipos;
    }

    /**
     * Establece el JComboBox de equipos.
     * @param cbEquipos el JComboBox de equipos a establecer
     */
    public void setCbEquipos(JComboBox cbEquipos) {
        this.cbEquipos = cbEquipos;
    }


    /**
     * Obtiene el panel principal de la ventana.
     * @return el panel principal
     */
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    /**
     * Establece el panel principal de la ventana.
     * @param panelPrincipal el panel principal a establecer
     */
    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    /**
     * Obtiene la lista de equipos.
     * @return la JList de equipos
     */
    public JList getlEquipos() {
        return lEquipos;
    }

    /**
     * Establece la lista de equipos.
     * @param lEquipos la JList de equipos a establecer
     */
    public void setlEquipos(JList lEquipos) {
        this.lEquipos = lEquipos;
    }
}
