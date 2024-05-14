package controlador.controladorV;

import vista.VistaLogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVPrincipal {
    private controladorV cv;
    private VistaLogin vl;

    public ControladorVPrincipal(controladorV cv){
        this.cv = cv;


    }

    public void mostrarVentanaPrincipal()
    {
        // Area De login
        vl = new VistaLogin();

        vl.addBEntrarAl(new BLoginAl());
        vl.addBSalirAl(new BSalirAl());

    }


    public class BLoginAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            var nombreUsuario = vl.getTfUsuario().getText();
            var contrasenaUsuario = vl.getTfContrasena().getText();


        }
    }

    public class BSalirAl implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(1);
        }
    }
}
