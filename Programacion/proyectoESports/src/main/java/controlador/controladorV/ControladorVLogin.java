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
    private boolean usuarioCorrecto = false;


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


            try {
                u = cv.buscarUsuario(nombreUsuario);

                if (u == null){
                    throw new Exception("Nombre o Contraseña invalida");
                }else {
                    if (u != null && u.getContrasena().equals(contrasenaUsuario)) {
                        usuarioCorrecto = true;
                    } else {
                        vl.muestra("Usuario Incorrecto");
                    }
                }

            }catch (Exception ex){
                vl.muestra(ex.getMessage());
            }

            if (usuarioCorrecto) {
                vl.dispose();
                var rolUsuario = u.getRol();
                cv.mostrarPrincipal(rolUsuario);
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
