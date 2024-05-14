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
