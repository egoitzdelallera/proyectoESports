package controlador.controladorV;

import modelo.Juego;
import modelo.Usuario;
import vista.VistaUsuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

public class ControladorVUsuarios {
    private VistaUsuarios vu;
    private ControladorV cv;
    private List<Usuario> lista;
    private int combo = 0;
    private Usuario us;
    public ControladorVUsuarios(ControladorV cv) {
        this.cv = cv;
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

        lista = cv.comboUsuarios();
        lista.forEach(o->vu.getCbUsuarios().addItem(o.getNombre()));
    }
    public class CbUsuariosAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            combo = vu.getCbUsuarios().getSelectedIndex();
            if (combo == 0){
                vu.getPanelCrear().setVisible(true);
            }else {
                vu.getPanelDatos().setVisible(true);

                try {
                    us = cv.buscarUsuario(vu.getCbUsuarios().getItemAt(combo).toString());
                    vu.getTaDatos().setText(us.getNombre()+"\n"+us.getContrasena());
                    vu.getTfNombre().setText(us.getNombre());



                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }

        }
    }
    public class BEditarAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            vu.getPanelCrear().setVisible(true);
        }
    }
    public class BBorrarAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                cv.borrarUsuario();
                //TODO Actualizar combo box
            }catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    public class BAceptarAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if(combo == 0) {
                    us = new Usuario();
                }
                us.setNombre(vu.getTfNombre().getText());
                us.setContrasena(vu.getTfContrasena().getText());
                if(vu.getRbUsuario().isSelected()) us.setRol("USUARIO");
                else us.setRol("ADMINISTRADOR");
                cv.insertarUsuario(us);
                System.out.println("Usuario insertado");
                vu.limpiar();

                //TODO actualizar combo box con el usuario insertado
            }catch (Exception ex) {
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
