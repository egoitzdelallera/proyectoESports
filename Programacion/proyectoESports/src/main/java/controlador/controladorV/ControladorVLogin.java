package controlador.controladorV;

/*
  Este es la Vista del login, es lo primero que aparece nada mas iniciamos el programa, damos usuario y contraseña,
   si lo busca entra en el ejercicio. si no, salta error diciendo que usuario o contraseña es incorrecto.
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

            int intentos = 0;

            while (intentos < 5) {
                try {
                    u = cv.buscarUsuario(nombreUsuario);
                    if (u != null && u.getContrasena().equals(contrasenaUsuario)) {
                        usuarioCorrecto = true;
                        break;
                    } else {
                        vl.muestra("Usuario Incorrecto");
                    }
                } catch (Exception ex) {
                    vl.muestra(ex.getMessage());
                }
                intentos++;
            }

            if (usuarioCorrecto) {
                vl.dispose();
                cv.mostrarPrincipal();
            } else if (intentos == 5) {
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
