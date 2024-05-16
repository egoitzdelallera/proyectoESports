
package controlador;

import controlador.controladorM.ControladorM;
import controlador.controladorV.ControladorV;
import modelo.Usuario;

public class ControladorPrincipal {
    private ControladorV cv;
    private ControladorM cm;

    public ControladorPrincipal() {
        cv = new ControladorV(this);
        cm = new ControladorM();
        System.out.println("Creados");


    }
    public void terminar() throws Exception
    {
        System.exit(0);
    }

    // Parte del Usuario

    public Usuario buscarUsuario(String nombre) throws Exception
    {
        return cm.buscarUsuario(nombre);
    }

}



