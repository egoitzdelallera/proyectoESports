
package controlador.controladorV;

import controlador.ControladorPrincipal;

public class ControladorV{
    private ControladorPrincipal cp;
    private ControladorVPrincipal cpp;
    private ControladorVEquipos cve;
    private ControladorVJugadores cvjd;
    private ControladorVLogin cvp;

    public ControladorV(ControladorPrincipal cp) {
        this.cp = cp;
        cvp = new ControladorVLogin(this);
        cpp = new ControladorVPrincipal(this);
        cve = new ControladorVEquipos(this);
        cvjd = new ControladorVJugadores(this);

        cvp.mostrarVentanaPrincipal();
    }
    public void mostrarEquipos(){
        cve.mostrarEquipos();
    }
    public void mostrarJugadores(){
        cvjd.mostrarJugadores();
    }
    /*
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

