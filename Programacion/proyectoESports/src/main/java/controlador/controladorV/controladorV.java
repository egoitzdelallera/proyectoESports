package controlador.controladorV;

import controlador.ControladorPrincipal;

public class ControladorV{
    private ControladorPrincipal cp;
    private ControladorPPrincipal cpp;
    private ControladorVEquipos cve;

    public ControladorV(ControladorPrincipal cp) {
        this.cp = cp;
    }
    public void mostrarEquipos(){
        cve.mostrarEquipos();
    }
   /* public void mostrarJugadores(){
        cvjd.mostrarJugadores();
    }
    public void mostrarCompeticiones(){
        cvc.mostrarCompeticiones();
    }
    public void mostrarJuegos(){
        cvjg.mostrarJuegos();
    }
    public void mostrarStaff(){
        cvs.mostrarStaff();
    }
    public void mostrarPatrocinadores(){
        cvp.mostrarPatrocinadores();
    }
    public void mostrarUsuarios(){
        cvu.mostrarUsuarios();
    }
    public void mostrarPrincipal(){
        cpp.mostrarPrincipal();
    }*/

    public void terminar() throws Exception
    {
        // Han hecho clic en el botón salir.
        cp.terminar();
    }
}
