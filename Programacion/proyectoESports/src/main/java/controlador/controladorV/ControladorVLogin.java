package controlador.controladorV;

/**
 * Este es la Vista del login, es lo primero que aparece nada mas iniciamos el programa, damos usuario y contraseña, si lo busca entra en el ejercicio. si no, salta error diciendo que usuario o contraseña es incorrecto.
 */

import modelo.Usuario;
import vista.VistaLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVLogin {
    private ControladorV cv;
    private VistaLogin vl;
    private Usuario u;
    private boolean usuarioCorrecto;


    public ControladorVLogin(ControladorV cv){
        this.cv = cv;
    }
    public void mostrarLogin()
    {
        // Area De login
        vl = new VistaLogin();

        vl.addBEntrarAl(new BLoginAl());
        vl.addBSalirAl(new BSalirAl());

        usuarioCorrecto =false;

        vl.setVisible(true);
    }

    public class BLoginAl implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            var nombreUsuario = vl.getTfUsuario().getText();
            var contrasenaUsuario = vl.getTfContrasena().getText();
            int i;
            for(i=0; i<5;i++) {
                try {
                    u = cv.buscarUsuario(nombreUsuario);
                    if (u.getContrasena().equals(contrasenaUsuario)) {
                        usuarioCorrecto = true;
                    }
                } catch (Exception ex) {
                    vl.muestra(ex.getMessage());
                }
                if (usuarioCorrecto) {
                    cv.mostrarPrincipal();
                } else vl.muestra("Usuario Incorrecto");
            }
            if(i==5){
                vl.muestra("Demasiados Intentos");
                try {
                    cv.terminar();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    public class BSalirAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                cv.terminar();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
