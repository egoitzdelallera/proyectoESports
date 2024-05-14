package controlador.controladorV;

import controlador.ControladorPrincipal;

public class controladorV {
    private ControladorPrincipal cp;
    private ControladorVPrincipal cvp;


    public controladorV(ControladorPrincipal cp){
        this.cp = cp;

        cvp = new ControladorVPrincipal(this);


    }
}
