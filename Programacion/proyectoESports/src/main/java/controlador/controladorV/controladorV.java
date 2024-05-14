package controlador.controladorV;

import controlador.ControladorPrincipal;

public class ControladorV{
    private ControladorPrincipal cp;
    private ControladorPPrincipal cpp;

    public ControladorV(ControladorPrincipal cp) {
        this.cp = cp;
    }
    public void mostrarEquipos(){
        cve.mostrarEquipos();
    }
    public void mostrarJugadores(){
        cvjd.mostrarEquipos();
    }
    public void mostrarCompeticiones(){
        cvc.mostrarEquipos();
    }
    public void mostrarJuegos(){
        cvjg.mostrarEquipos();
    }
    public void mostrarStaff(){
        cvs.mostrarEquipos();
    }
    public void mostrarPatrocinadores(){
        cvp.mostrarEquipos();
    }
    public void mostrarUsuarios(){
        cvu.mostrarEquipos();
    }
    public void mostrarPrincipal(){
        cpp.mostrarPrincipal();
    }
}
