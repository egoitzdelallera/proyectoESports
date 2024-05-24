package vista;

import javax.swing.*;
import java.awt.event.*;

/**
 * Vista para la interfaz de login.
 */
public class VistaLogin extends JFrame {
    private JPanel contentPane;
    private JButton bEntrar;
    private JButton bSalir;
    private JTextField tfUsuario;
    private JTextField tfContrasena;


    /**
     * Constructor de la clase VistaLogin.
     * Inicializa la vista de login.
     */
    public VistaLogin() {
        setContentPane(contentPane);
        setSize(600, 200);
        getRootPane().setDefaultButton(bEntrar);
        setLocationRelativeTo(null);
    }

    /**
     * Obtiene el botón de entrar.
     *
     * @return JButton de entrar.
     */
    public JButton getbEntrar() {
        return bEntrar;
    }

    /**
     * Establece el botón de entrar.
     *
     * @param bEntrar JButton de entrar.
     */
    public void setbEntrar(JButton bEntrar) {
        this.bEntrar = bEntrar;
    }

    /**
     * Obtiene el botón de salir.
     *
     * @return JButton de salir.
     */
    public JButton getbSalir() {
        return bSalir;
    }

    /**
     * Establece el botón de salir.
     *
     * @param bSalir JButton de salir.
     */
    public void setbSalir(JButton bSalir) {
        this.bSalir = bSalir;
    }

    /**
     * Obtiene el JTextField para ingresar el usuario.
     *
     * @return JTextField para ingresar el usuario.
     */
    public JTextField getTfUsuario() {
        return tfUsuario;
    }

    /**
     * Establece el JTextField para ingresar el usuario.
     *
     * @param tfUsuario JTextField para ingresar el usuario.
     */
    public void setTfUsuario(JTextField tfUsuario) {
        this.tfUsuario = tfUsuario;
    }

    /**
     * Obtiene el JTextField para ingresar la contraseña.
     *
     * @return JTextField para ingresar la contraseña.
     */
    public JTextField getTfContrasena() {
        return tfContrasena;
    }

    /**
     * Establece el JTextField para ingresar la contraseña.
     *
     * @param tfContrasena JTextField para ingresar la contraseña.
     */
    public void setTfContrasena(JTextField tfContrasena) {
        this.tfContrasena = tfContrasena;
    }


    /**
     * Agrega un ActionListener al botón de entrar.
     *
     * @param al ActionListener a ser agregado.
     */
    public void addBEntrarAl(ActionListener al){
        bEntrar.addActionListener(al);
    }

    /**
     * Agrega un ActionListener al botón de salir.
     *
     * @param al ActionListener a ser agregado.
     */
    public void addBSalirAl(ActionListener al){
        bSalir.addActionListener(al);
    }

    /**
     * Muestra un mensaje en un cuadro de diálogo.
     *
     * @param mensaje El mensaje a mostrar.
     */
    public void muestra(String mensaje){
        JOptionPane.showMessageDialog(contentPane, mensaje);
    }
}
