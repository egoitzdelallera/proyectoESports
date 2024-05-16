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


    public ControladorVLogin(ControladorV cv){
        this.cv = cv;
    }
    public void mostrarLogin()
    {
        // Area De login
        vl = new VistaLogin();

        vl.addBEntrarAl(new BLoginAl());
        vl.addBSalirAl(new BSalirAl());

        vl.setVisible(true);
    }

    public class BLoginAl implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            var nombreUsuario = vl.getTfUsuario().getText();
            var contrasenaUsuario = vl.getTfContrasena().getText();

            cv.mostrarPrincipal();
            try {
                u = cv.buscarUsuario(nombreUsuario);
            } catch (Exception ex) {
                vl.muestra(ex.getMessage());
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
