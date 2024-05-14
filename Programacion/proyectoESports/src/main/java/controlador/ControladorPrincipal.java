<<<<<<< HEAD
package controlador;

import controlador.controladorM.ControladorM;
import controlador.controladorV.ControladorV;

public class ControladorPrincipal {
    private ControladorV cv;
    private ControladorM cm;
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
=======
package controlador;

import controlador.controladorM.controladorM;
import controlador.controladorV.controladorV;

public class ControladorPrincipal {
    private controladorV cv;
    private controladorM cm;

    public ControladorPrincipal(){
        cv = new controladorV(this);
        cm = new controladorM();
    }

}
>>>>>>> develop
