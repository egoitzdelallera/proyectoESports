package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VistaLogin extends JFrame {
    private JPanel contentPane;
    private JButton bEntrar;
    private JButton bSalir;
    private JTextField tfUsuario;
    private JTextField tfContrasena;

    public VistaLogin() {
        setContentPane(contentPane);
        setSize(600, 200);
        getRootPane().setDefaultButton(bEntrar);
        setLocationRelativeTo(null);

    }


    public JButton getbEntrar() {
        return bEntrar;
    }

    public void setbEntrar(JButton bEntrar) {
        this.bEntrar = bEntrar;
    }

    public JButton getbSalir() {
        return bSalir;
    }

    public void setbSalir(JButton bSalir) {
        this.bSalir = bSalir;
    }

    public JTextField getTfUsuario() {
        return tfUsuario;
    }

    public void setTfUsuario(JTextField tfUsuario) {
        this.tfUsuario = tfUsuario;
    }

    public JTextField getTfContrasena() {
        return tfContrasena;
    }

    public void setTfContrasena(JTextField tfContrasena) {
        this.tfContrasena = tfContrasena;
    }

    public void addBEntrarAl(ActionListener al){
        bEntrar.addActionListener(al);
    }

    public void addBSalirAl(ActionListener al){
        bSalir.addActionListener(al);
    }
    public void muestra(String mensaje){
        JOptionPane.showMessageDialog(contentPane, mensaje);
    }
}
