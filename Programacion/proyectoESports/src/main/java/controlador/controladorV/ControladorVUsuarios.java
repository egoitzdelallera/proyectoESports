package controlador.controladorV;

import modelo.Usuario;
import vista.VistaUsuarios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControladorVUsuarios {
    private VistaUsuarios vu;
    private ControladorV cv;
    private Usuario us;
    private List<Usuario> listaUs;
    private int combo = 0;
    private JComboBox combobox;

    public ControladorVUsuarios(ControladorV cv) {
        this.cv = cv;
    }

    public void rellenarLista() {
        listaUs = cv.comboUsuarios();
        combobox = vu.getCbUsuarios();
        combobox.removeAllItems();
        combobox.addItem("Selecciona");
        combobox.addItem("Nuevo");
        listaUs.forEach(o -> combobox.addItem(o.getNombre()));
    }

    public void mostrarUsuarios() {
        vu = new VistaUsuarios();

        vu.addBAceptarAl(new BAceptarAl());
        vu.addBBorrarAl(new BBorrarAl());
        vu.addBEditarAl(new BEditarAl());
        vu.addCbUsuariosAl(new CbUsuariosAl());
        vu.addBSalirAl(new BSalirAl());

        vu.setVisible(true);
        vu.getPanelComboBox().setVisible(true);
        vu.getPanelCrear().setVisible(false);
        vu.getPanelDatos().setVisible(false);

        rellenarLista();
    }

    public class CbUsuariosAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            combo = combobox.getSelectedIndex();
            if (combo >= 1) {
                if (combo == 1) {
                    vu.getPanelCrear().setVisible(true);
                    vu.getPanelDatos().setVisible(false);
                    vu.limpiar();
                } else {
                    vu.getPanelDatos().setVisible(true);
                    vu.getPanelCrear().setVisible(false);

                    try {
                        us = cv.buscarUsuario(combobox.getItemAt(combo).toString());
                        vu.getTaDatos().setText("Nombre: " + us.getNombre() + "\nContraseña: " + us.getContrasena() + "\nRol: " + us.getRol());
                        vu.getTfNombre().setText(us.getNombre());
                        vu.getTfContrasena().setText(us.getContrasena());
                        if (us.getRol().equals("USUARIO")) {
                            vu.getRbUsuario().setSelected(true);
                        } else {
                            vu.getRbAdministrador().setSelected(true);
                        }
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        }
    }

    public class BEditarAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vu.getPanelCrear().setVisible(true);
            vu.getPanelDatos().setVisible(false);
        }
    }

    public class BAceptarAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            combobox = vu.getCbUsuarios();
            try {
                if (combo == 1) {
                    us = new Usuario();
                }
                us.setNombre(vu.getTfNombre().getText());
                us.setContrasena(vu.getTfContrasena().getText());
                if (vu.getRbUsuario().isSelected()) {
                    us.setRol("USUARIO");
                } else {
                    us.setRol("ADMINISTRADOR");
                }
                cv.insertarUsuario(us);
                System.out.println("Usuario insertado");
                vu.limpiar();
                rellenarLista();
                vu.getPanelDatos().setVisible(false);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public class BBorrarAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (combo > 1) {
                    cv.borrarUsuario();
                    vu.limpiar();
                    rellenarLista();
                    vu.getPanelDatos().setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(vu, "Seleccione un usuario válido para borrar.");
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public class BSalirAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vu.dispose();
        }
    }
}
