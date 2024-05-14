
package controlador;

import controlador.controladorM.ControladorM;
import controlador.controladorV.ControladorV;

public class ControladorPrincipal {
    private ControladorV cv;
   // private ControladorM cm;

    public ControladorPrincipal() {
        cv = new ControladorV(this);
       // cm = new ControladorM(this);
        System.out.println("Creados");


    }
    public void terminar() throws Exception
    {
        System.exit(0);
    }

}



